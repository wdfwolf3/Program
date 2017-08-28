package program.javaTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

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

    public void typeTransform(){
        int n = 1222222;
        long l = 1222222222;
        float f = n;//有可能失去精度
        f = l;//有可能失去精度
    }

    public void BigIntegerTest(){
        BigInteger bigInteger = new BigInteger("1234");
        bigInteger = bigInteger.add(BigInteger.valueOf(5)).divide(BigInteger.valueOf(5));
        System.out.println(bigInteger);

        BigDecimal bigDecimal = new BigDecimal("12.22");
        bigDecimal = BigDecimal.valueOf(22222,4);
        System.out.println(bigDecimal);
    }

    public void ArrayTest(){
        int[] nums = new int[]{1,2,3,4,5};
        nums = Arrays.copyOf(nums, 3);
        nums = Arrays.copyOfRange(nums, 0, 4);
        for(int i: nums)
            System.out.println(i);
        System.out.println(nums.getClass().getName());
    }

    public static void main(String[] args) {
        IntegerTest integerTest = new IntegerTest();
        integerTest.BigIntegerTest();
        integerTest.ArrayTest();
        System.out.println(args.length);
    }
}
