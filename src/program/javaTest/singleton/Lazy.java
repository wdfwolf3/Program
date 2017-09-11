package program.javaTest.singleton;

/**
 * Created by wdfwolf3 on 2017/9/8.
 */
public class Lazy {
    private static Lazy instance;

    private Lazy() {
    }

    public static synchronized Lazy getInstance() {
        if (instance == null)
            instance = new Lazy();
        return instance;
    }
}
