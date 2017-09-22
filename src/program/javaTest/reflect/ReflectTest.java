package program.javaTest.reflect;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fung on 2017/7/6.
 */
public class ReflectTest {
    List<Integer> myList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Field field = null; //myList的类型是List
        try {
            field = ReflectTest.class.getDeclaredField("myList");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) type;
            Type[] actualTypes = paramType.getActualTypeArguments();
            for (Type aType : actualTypes) {
                if (aType instanceof Class) {
                    Class clz = (Class) aType;
                    System.out.println(clz.getName()); //输出java.lang.String
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method;
        try {
            method = list.getClass().getMethod("add", Object.class);
            method.invoke(list, "Java反射机制实例。");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0));

        List<Integer> list2 = getList(list);
        list2.add(0);
        if (list instanceof List) {
            System.out.println(1);
        }
        if (list2 instanceof List) {
            System.out.println(2);
        }
        if (list2 instanceof Proxy) {
            System.out.println(2);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Integer> getList(final List<Integer> list) {
        Object proxy = Proxy.newProxyInstance(ReflectTest.class.getClassLoader(), new Class[]{List.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("add".equals(method.getName())) {
                            method.invoke(list, 0);
                            return method.invoke(list, args);
//	                    throw new UnsupportedOperationException();
                        } else {
                            return method.invoke(list, args);
                        }
                    }
                });
        return (List<Integer>) proxy;
    }


}
