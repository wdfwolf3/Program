package program.javaTest;

import java.util.ArrayList;
import java.util.List;

public class Te1 {
    public static void main(String[] args) {
        ArrayList<? extends T> list = new ArrayList<A>();
//        list.add(new T());
    }
}

class T {
}

class A extends T {
}

class B extends A {
}

