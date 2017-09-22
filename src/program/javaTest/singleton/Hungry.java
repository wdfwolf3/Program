package program.javaTest.singleton;

/**
 * Created by wdfwolf3 on 2017/9/8.
 */
public class Hungry {
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }
}
