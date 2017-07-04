package program.javaTest;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/28.
 */
public class ClassTest {
    public static void main(String[] args) {
        Class finalTest = FinalTest.class;
        try {
            Class finalTes = Class.forName("program.javaTest.FinalTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FinalTest finalTest1 = (FinalTest) finalTest.newInstance();
            Class finalTes = finalTest1.getClass();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            Constructor constructor = finalTest.getDeclaredConstructor();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        Proxy.newProxyInstance(finalTest.getClassLoader(), new Class[]{FinalTest.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                if ("add".equals(method.getName())) {
                    throw new UnsupportedOperationException();
                } else {
                    return method.invoke(list, args);
                }
            }
        });
    }
}
