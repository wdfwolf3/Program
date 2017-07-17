package program.javaTest;

import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/22.
 */
public class ReloadTest {
//    public static void method(List<String> list){
//
//    }
    public static void main(String[] args)
        throws Exception {
            try {
                try {
                    throw new Sneeze();
                } catch (Annoyance a) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            } catch (Sneeze s) {
                System.out.println("Caught Sneeze");
                return;
            } finally {
                System.out.println("Hello World!");
            }
//        try{
//            throw new Annoyance();
//        }catch (Sneeze s){
//            System.out.println("s");
//        }finally {
//            throw new Exception();
//        }


    }

    public static int method(List<Integer> list){
        assert 5 != 5;
        return 5;
    }
}
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

