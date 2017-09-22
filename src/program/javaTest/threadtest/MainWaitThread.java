package program.javaTest.threadtest;

public class MainWaitThread {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start!");
                long l = System.currentTimeMillis();
                while (System.currentTimeMillis() - l < 3000);
                System.out.println("Thread stop!");
            }
        });
        thread.start();
        System.exit(0);
    }
}
