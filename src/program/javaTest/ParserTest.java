package program.javaTest;

/**
 * Created by Fung on 2017/7/12.
 */
public class ParserTest {
    public static void main(String[] args){
        System.out.println(Child.m);
    }
}

class Super{
//    public static int m = 11;
    static{
        System.out.println("执行了super类静态语句块");
    }
}

class Father extends Super{
    public static int m = 33;
    static{
        System.out.println("执行了父类静态语句块");
    }
}

class Child extends Father{
    static{
        System.out.println("执行了子类静态语句块");
    }
}

