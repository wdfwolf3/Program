package program.niuke;


import java.util.Random;

public class Mudiao{
    public String getString(String[] w, int[] f){
        int[] p = new int[w.length];
        p[0] = f[0];
        for (int i = 1; i < w.length; i++)
            p[i] = p[i-1] + f[i];
        Random random = new Random();
        int r = random.nextInt(p[w.length-1]), index = 0;
        for (int i = 0; i < w.length; i++)
            if (p[i] > r){
                index = i;
                break;
            }
        return w[index];
    }

    int func(int x){
        if (x < 2)
            return 1;
        int pre = 1, cur = 1;
        for (int i = 2; i <= x; i++) {
            int tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Mudiao mudiao = new Mudiao();
        String[] strings = {"aa","b","c","d"};
        int[] nums = {1,2,3,4};
        System.out.println(mudiao.getString(strings, nums));
        Machine machine = new Machine();
        machine.feed(new Chicken());
        machine.feed(new Duck());
    }
}

//public class Singleton {
//    private volatile static Singleton instance;
//
//    private Singleton() {
//    }
//
//    public static Singleton getSingleton() {
//        if (instance == null)
//            synchronized (Singleton.class) {
//                if (instance == null)
//                    instance = new Singleton();
//            }
//        return instance;
//    }
//}
