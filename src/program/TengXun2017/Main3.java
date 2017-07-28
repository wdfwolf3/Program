package program.TengXun2017;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/7/2.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ans = 0;
            for (int i = 2; i <= n / 2; i++) {
                if (help(i) && help(n - i))
                    ans++;
            }
            System.out.println(ans);
        }
    }

    public static boolean help(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
