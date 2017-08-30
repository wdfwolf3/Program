package program.exam.jingdong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str1 = sc.next();
            String str2 = sc.next();
            int tmp = 1, ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                int num1 = str1.charAt(i) - '0';
                int num2 = str2.charAt(i) - '0';
                ans += (num1 ^ num2) * tmp;
                tmp *= 2;
            }
            System.out.println(ans);
        }
    }

    public static double help(int start, int end, int count, double[] p) {
        if (count == 0) {
            return 1;
        }
        if (count > (end - start)) {
            return 0;
        }
        if (start == end) {
            return 0;
        }
        if (p[start] < 0.001) {
            return help(start + 1, end, count, p);
        } else if (p[start] > 0.999) {
            return help(start + 1, end, count - 1, p);
        }
        return p[start] * help(start + 1, end, count - 1, p)
                + (1.0 - p[start]) * help(start + 1, end, count, p);
    }
}