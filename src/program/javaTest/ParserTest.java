package program.javaTest;

import java.util.HashMap;

/**
 * Created by Fung on 2017/7/12.
 */
public class ParserTest {
    public static void main(String[] args) {
        System.out.println(Child.m);
        Father father = new Father();
        System.out.println(father instanceof Child);
        System.out.println(father instanceof Super);

        HashMap<Super, Integer> map = new HashMap<>();

    }
}

class Super {
    //    public static int m = 11;
    static {
        System.out.println("执行了super类静态语句块");
    }

    private final void pr() {

    }

    protected String get() {
        return "";
    }
}

class Father extends Super {
    public static int m = 33;

    static {
        System.out.println("执行了父类静态语句块");
    }

    private final void pr() {

    }

    private float get(double d) {
        return 0;
    }
}

class Child extends Father {
    static {
        System.out.println("执行了子类静态语句块");
    }
}

