package program.javaTest;

import java.util.List;

public class Test {


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,null));
//        list = list.subList(2,4);
//        System.out.println(list.size());
//        ArrayList<A> list1 = new ArrayList<A>();
//        list1.add(new B());
//        method(list1);
//        double i = 1.0/0.0;
//        int i1= 1/0;
//        long i11= 4*0x7fffffff;
//        byte b = 20<<1;
//        try{
//            System.out.println(1);
//            return;
//        }catch (Exception e){
//
//        }finally {
//
//        }
        int i = 0;
        int j = (i++) + (++i);
        j += ++j;
        int k = (j > 0) ? j : ++j;
        System.out.println("" + i + j + k);

        String a = "helloworld";
        final String b = "hello";
        String d = "hello";
        String c = b + "world";
        String e = d + "world";
        System.out.println(a == c);
        System.out.println(a == e);
//        Test test = new Test();
//        test.aa(null);
        Other o = new Other();
        new Test().bb(o);
        System.out.println(o.i);
    }

    public void bb(final Other o) {
        o.i++;
    }

    public void aa(Object o) {
        System.out.println(1);
    }

    public void aa(String s) {
        System.out.println(2);

//        List aaa = new ArrayList<? extends Collection>();
    }

    public static void method(List<? super A> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(0));
        }
    }

    static class A {

    }

    static class B extends A {

    }
}

class Other {
    public int i;
}

