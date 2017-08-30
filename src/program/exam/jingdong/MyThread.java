package program.exam.jingdong;

/**
 * Created by wdfwolf3 on 2017/4/28.
 */
class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
