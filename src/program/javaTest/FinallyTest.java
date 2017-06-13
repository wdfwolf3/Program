package program.javaTest;

/**
 * Created by wdfwolf3 on 2017/6/8.
 */
public class FinallyTest {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(finalTest(n));
    }

    /**
     * 执行try语句,包括return后的语句，保留返回值，然后执行finally，如果有return则返回，如果没有执行完finally语句后按try中return
     * 返回.如果try抛出异常进入catch，同理。
     *
     * @param n
     * @return
     */
    public static int finalTest(int n) {
        try {
            System.out.println("try:");
//            throw new Exception("exception");
            return ++n;
        } catch (Exception e) {
            System.out.println("catch:");
//            return ++n;
        } finally {
            System.out.println("finally");
            n++;
//            return ++n;
        }
        return ++n;
    }
}
