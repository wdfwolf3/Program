package program.javaTest.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 每个循环次数          100000  1000000  10000000  100000000
 * synchronized(ms)      29      265      3293     47789
 * ReentrantLock(ms)     79      165      1473     14923
 * volatile(ms)       count++非原子操作不能同步
 * <p>
 * 10000000次 线程数       2     5     8     15
 * synchronized(ms)     661   3293  7084  11380
 * ReentrantLock(ms)    767   1473  2342  3672
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        //线程数
        int threadNum = 5;
        Syn syn = new Syn();
        Thread[] threads = new Thread[threadNum];
        //记录运行时间
        long l = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        syn.increaseLock();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有线程结束
        try {
            for (int i = 0; i < threadNum; i++)
                threads[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(syn + " : " + (System.currentTimeMillis() - l) + "ms");
    }
}

class Syn {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    //利用synchronized
    public void increase() {
        synchronized (this) {
            count++;
        }
    }

    //利用ReentrantLock类同步
    public void increaseLock() {
        lock.lock();
//        if (count == 5000000)
//            System.out.println(lock);
        count++;
        lock.unlock();
    }

    public void increaseVolatile() {
        count = count + 1;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
