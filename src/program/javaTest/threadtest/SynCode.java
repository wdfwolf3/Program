package program.javaTest.threadtest;

/**
 * Created by wdfwolf3 on 2017/5/5.
 */
public class SynCode {
    public synchronized void synCode(int id) {
        for (int i = 0; i < 10; i++) {
            System.out.println(id + ":syn");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notSynCode() {
        for (int i = 0; i < 10; i++) {
            System.out.println("notSyn");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
