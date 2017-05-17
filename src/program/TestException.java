package program;

/**
 * Created by wdfwolf3 on 2017/2/15.
 */
public class TestException extends NumberFormatException{
    String message;
    public TestException(String e){
        message = e;
    }

    public String getMessage(){
        return message;
    }
}
