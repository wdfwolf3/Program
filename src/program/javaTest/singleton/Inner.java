package program.javaTest.singleton;

/**
 * Created by wdfwolf3 on 2017/9/8.
 */
public class Inner {
    private static class SingletonHolder {
        private static final Inner INSTANCE = new Inner();
    }

    private Inner() {
    }

    public static final Inner getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
