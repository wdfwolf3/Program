package program.javaTest.generics;

import java.util.concurrent.TimeUnit;

/**
 * Created by wdfwolf3 on 2017/6/28.
 */
public class Main {
    public static void main(String[] args) {
        Generics<String> generics = new Generics<>();
        generics.setT("ADF");
        String string = generics.getT();

        Two<Integer, String> two = new Two<>();
        two.set(1, "23");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
