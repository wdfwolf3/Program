package program.MyThread;

/**
 * Created by wdfwolf3 on 2017/5/5.
 */
public class ThreadMain {
    public static void main(String[] args) {
        SynCode synCode = new SynCode();
        Thread thread1 = new Thread(new Thread1(synCode));
        Thread thread2 = new Thread(new Thread2(synCode));
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
