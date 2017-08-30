package program.exam.jingdong;

public class Sett {
    public static void main(String[] args) {
//        System.out.println(fib(1000));
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        BinarySearch.binarySearch(nums, 3);
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("world");
//        int i = 0;
//        switch (i) {
//            default:
//                System.out.println("default");
//            case 0:
//                System.out.println("0");
//            case 1:
//                System.out.println("1");
//            case 2:
//                System.out.println("2");
//                break;
//            case 3:
//                System.out.println("3");
//            case 4:
//                System.out.println("4");
//                break;
//        }
    }

    static synchronized void hello() {
        System.out.println("hello");
    }

    private static int fib(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
