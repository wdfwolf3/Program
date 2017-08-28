package program.niuke;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Fung on 2017/7/3.
 */
public class NiuKe {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(1, null);
        //不允许key,value为空
        Hashtable<Integer, Integer> table = new Hashtable<>();
//        table.put(null, 2);
//        table.put(2, null);

        /**
         *  一、关于final的重要知识点;
         1、final关键字可以用于成员变量、本地变量、方法以及类。
         2、 final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。
         3、 你不能够对final变量再次赋值。
         4、 本地变量必须在声明时赋值。
         5、 在匿名类中所有变量都必须是final变量。
         6、 final方法不能被重写。
         7、 final类不能被继承。
         8、 没有在声明时初始化final变量的称为空白final变量(blank final variable)，它们必须在构造器中初始化，或者调用this()初始化。不这么做的话，编译器会报错“final变量(变量名)需要进行初始化”。
         二、数据类型转换
         当使用 +、-、*、/、%、运算操作是，遵循如下规则：
         只要两个操作数中有一个是double类型的，另一个将会被转换成double类型，并且结果也是double类型，如果两个操作数中有一个是float类型的，另一个将会被转换为float类型，并且结果也是float类型，如果两个操作数中有一个是long类型的，另一个将会被转换成long类型，并且结果也是long类型，否则（操作数为：byte、short、int 、char），两个数都会被转换成int类型，并且结果也是int类型。
         语句 1  :（b1 + b2） 被转换为int类型 但是 b3仍为 byte ，所以出错 要么将b3转化为int 要么将（b1 + b2） 强制转换为byte类型。所以语句1错误。
         语句 2：b4 、b5被声明final 所以类型是不会转换， 计算结果任然是byte  ，所以 语句2正确。
         语句 3：(b1 + b4)  结果仍然转换成int  所以语句 3 错误。
         语句 4 : (b2 + b5)  结果仍然转换为int ， 所以语句4错误
         */
        byte b = (byte) 222;   //cannot cast int to byte
        //我们写的整数，没有明确指出类型（比如说 byte b = 4;中的4） 系统默认是int的，
        //那么为什么不会编译出错呢，这里（ 我认为 ）这个整数如果没有超出范围（比如 byte b = 4;在范围之内），编译系统有个自动转换。
        byte b1 = 1, b2 = 2, b3, b6, b8;
        final byte b4 = 4, b5 = 6, b7;
        //类型为byte，short，char类型的变量在运算的时候会自动转为int类型
//        b3=(b1+b2);  /*语句1*/
        b6 = b4 + b5;    /*语句2*/
//        b8=(b1+b4);  /*语句3*/
//        b7=(b2+b5);  /*语句4*/
        System.out.println(b6);

        NiuKe inc = new NiuKe();
        int i = 0;
        inc.fermin(i);
        i = i++;
        System.out.println(i);

    }

    void fermin(int i) {
        i++;
    }
}
