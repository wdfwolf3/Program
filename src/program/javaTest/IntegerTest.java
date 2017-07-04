package program.javaTest;

/**
 * Created by wdfwolf3 on 2017/6/28.
 */
public class IntegerTest {
    public void Test(){
        int i = 1;
        Integer integer = 1;
        Integer integer1 = new Integer(1);  //只有new了就是一个新的对象
        Integer integer2 = 1;             //适用于-128到127不创建新对象
        Integer integer3 = new Integer(i);
        System.out.println(i==integer3);   //有i则转换为比较值
        System.out.println(integer1==integer);//比较是否为同一个对象
    }
}
