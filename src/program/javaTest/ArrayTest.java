package program.javaTest;

import java.util.Arrays;

public class ArrayTest {
    public void typeCast(){
        int[] nums = new int[5];
        Object object =  nums;
        nums = (int[]) object;


        Integer[] integers = new Integer[5];
        Object[] o = integers;
        Object o1 = integers;
        System.out.println(Arrays.toString(o));


        Class c = integers.getClass();
        Class c1 = c.getComponentType();
        System.out.println(c1.getName());
        System.out.println(nums.getClass().getComponentType());
        System.out.println(object.getClass().getComponentType());
    }

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.typeCast();
    }
}
