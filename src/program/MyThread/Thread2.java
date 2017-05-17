package program.MyThread;

/**
 * Created by wdfwolf3 on 2017/5/5.
 */
public class Thread2 implements Runnable{
    SynCode synCode = new SynCode();

    public Thread2(SynCode synCode) {
        this.synCode = synCode;
    }

    @Override
    public void run(){
        SynCode synCode = new SynCode();
        synCode.synCode(2);
    }
}
