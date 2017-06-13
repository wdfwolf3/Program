package program.javaTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wdfwolf3 on 2017/6/9.
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        AnonymousInnerClassTest test = new AnonymousInnerClassTest();
        Map<Integer, Integer> map = new HashMap<>();
        //JDK1.8后不声明final自动添加final，不然传值的时候里面改变的是拷贝的备份，外面并不改变，看起来不合逻辑，所以直接规定生命为
        //final
        map.put(2,2);
        test.test(new Inner() {
            @Override
            public int test() {
//                map = new HashMap<>();
                map.put(2,1);
                return map.get(2);
            }
        });
        //map传址所以里面的改变影响到外面
        System.out.println(map.get(2));
    }

    public void test(Inner inner){
        System.out.println(inner.test());
    }
}

abstract class Inner{
    public abstract int test();
}
