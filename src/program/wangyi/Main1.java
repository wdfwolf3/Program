package program.wangyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            double x = in.nextInt();
            double f = in.nextInt();
            double d = in.nextInt();
            double p = in.nextInt();
            if (d < x * f) {
                System.out.println((int) (d / x));
                continue;
            }
            double s = d - f * x;
            int ans = (int) (s / (p + x));
            System.out.println((int) f + ans);
        }
    }
}
