package program.javaTest;

/**
 * Created by wdfwolf3 on 2017/6/20.
 */
public class VarargsTest {
    public static void main(String[] args) {
        args('a');
        char[] chars = {'a', 'a', 'b'};
        args(chars);
    }

    public static void args(char... chars) {
        char[] chars1 = chars;
        System.out.println(chars1);
        System.out.println("chars...");
    }
}
