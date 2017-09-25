package program.javaTest.jvm;

public class GCDetails {
    private static int M = 1024*1024;

    //-Xms20m -Xmx20m -XX:+PrintGCDetails
    public static void main(String[] args) throws InterruptedException {

        byte[] bytes = new byte[2*M];
        System.out.println(0);
        Thread.sleep(1000);
        byte[] bytes1 = new byte[2*M];
        System.out.println(1);
        Thread.sleep(1000);
        byte[] bytes2 = new byte[2*M];
        System.out.println(2);
        Thread.sleep(1000);
        byte[] bytes3 = new byte[2*M];
        System.out.println(3);
        Thread.sleep(1000);
        bytes1 = new byte[3*M];

    }
}
