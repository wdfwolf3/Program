package program.javaTest;

public class Te {
    static public int cnt = 0;

    public static void main(String[] args) {
        fib(7);
        System.out.println(cnt);
    }

    static int fib(int n) {
        cnt++;
        System.out.println(cnt < 010);
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else
            return fib(n - 1) + fib(n - 2);
    }
}
