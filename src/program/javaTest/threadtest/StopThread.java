package program.javaTest.threadtest;

public class StopThread implements Runnable {
    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        Thread thread = new Thread(stopThread);
        thread.start();
        System.out.println("thread starting...");

        try {
            thread.interrupt();
            Thread.sleep(1000);
            System.out.println("isInterrupted : " + thread.isInterrupted());
            Thread.sleep(3000);
            thread.join();
            System.out.println("main stop!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("entry catch block!");
            long l = System.currentTimeMillis();
            while (System.currentTimeMillis() - l < 5000) ;
        }
        System.out.println("thread stop!");
    }
}


