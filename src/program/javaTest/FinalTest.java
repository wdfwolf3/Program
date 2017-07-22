package program.javaTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/8.
 */
public class FinalTest extends Father{
    public static void main(String[] args) {
        test1();
        test2();
        Boolean
    }

    public static void test1(){
        String string = "23";
        final String s = string;
        string = "234";
        System.out.println(s+" "+string);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //final不能改变指向了，但是可以改变内容
        final List<Integer> newList = list;
        list.add(2);
        System.out.println(newList.size());
        include(newList);
        System.out.println(newList.size());
        Integer i = 3;
        System.out.println(i.hashCode());
        i = new Integer(4);
        System.out.println(i.hashCode());
        changeInteger(i);
        System.out.println(i);
    }

    public static void include(List<Integer> list){
        list.add(3);
        list = new ArrayList<>();
    }

    /**
     * Integer传地址，但是integer和i是两个对象指向同一地址，integer指向新的地址并不能影响到实参i。不过通过对integer的修改可以影响
     * 到i。
     * @param integer
     */
    public static void changeInteger(Integer integer){
        integer = new Integer(4);
    }

    public static void test2(){

    }

    public final void fi(){

    }

    public void fi(int i){

    }
}

class Father{
    private int n = 0;

    public Father(){

    }
}
