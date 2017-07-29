package program.javaTest.MultithreadTest;

public class NotifyThread implements Runnable{
    private Object object0;
    private Object object1;
    private int index;

    public NotifyThread(Object object0, Object object1, int index) {
        this.object0 = object0;
        this.object1 = object1;
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(index + "start");
        for (int i = 0; i < 10; i++) {
            synchronized (object0){
                synchronized (object1){
                    System.out.println(index + ":" + i);
                    object1.notify();
                }
                try {
                    object0.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(index + "end");
    }
}
