package program.javaTest.MultithreadTest;

import java.util.concurrent.TimeUnit;

public class PrintABC implements Runnable {
    private Object object1;
    private Object object2;
    private int index;

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();

        PrintABC waitThread0 = new PrintABC(object1, object3, 0);
        PrintABC waitThread1 = new PrintABC(object2, object1, 1);
        PrintABC waitThread2 = new PrintABC(object3, object2, 2);

        Thread thread0 = new Thread(waitThread0);
        Thread thread1 = new Thread(waitThread1);
        Thread thread2 = new Thread(waitThread2);

        try {
            thread0.start();
            TimeUnit.SECONDS.sleep(1);
            thread1.start();
            TimeUnit.SECONDS.sleep(1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public PrintABC(Object object1, Object object2, int index) {
        this.object1 = object1;
        this.object2 = object2;
        this.index = index;
    }

    @Override
    public void run() {
//        System.out.println(index + "start");
        for (int i = 0; i < 10; i++) {
            synchronized (object2) {
                synchronized (object1) {
//                    System.out.println(index + ":" + i);
                    System.out.println((char) ('A' + index));
                    object1.notify();
                }
                try {
                    if (i != 9) {
                        object2.wait();
                    } else
                        TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(index + "end");
    }
}
