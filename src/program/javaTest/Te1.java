package program.javaTest;

import java.util.ArrayList;
import java.util.List;

public class Te1 {
    public static void main(String[] args) {
        List<Class<? extends T>> list = new ArrayList<>();
        list.add(B.class);
    }
}

class T {
}

class A extends T {
}

class B extends A {
}

