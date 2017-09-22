package program.javaTest;


/**
 * Created by wdfwolf3 on 2017/2/15.
 */
public class TestException extends NumberFormatException {
    String message;

    public TestException(String e) {
        message = e;
        try {
            Thread.sleep(4);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public String getMessage() {
        int i = (int) Math.sqrt(2);
        return message;
    }
}
