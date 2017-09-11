package program.javaTest.singleton;

/**
 * Created by wdfwolf3 on 2017/9/8.
 */
public class DoubleLock {
    private volatile static DoubleLock instance;

    private DoubleLock() {
    }

    public static DoubleLock getSingleton() {
        if (instance == null)
            synchronized (DoubleLock.class) {
                if (instance == null)
                    instance = new DoubleLock();
            }
        return instance;
    }
}
