package program.javaTest;

import java.util.concurrent.Callable;

public class Sougou implements Runnable{
    public static void main(String[] args) {
        Long a = new Long(10);
        long b =10;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        Long c = new Long(10);
        System.out.println(a==c);
        Sougou s = new Sougou();
        Thread t = new Thread(s);

        testMethod();
    }

    public static void testMethod(){
        System.out.println("testMethod");
    }

    @Override
    public void run() {

    }
}

