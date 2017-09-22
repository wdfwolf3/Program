package program.exam.aiqiyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt(), k1 = in.nextInt(), x2 = in.nextInt(), k2 = in.nextInt();
        StringBuilder s1 = new StringBuilder(String.valueOf(x1));
        StringBuilder s2 = new StringBuilder(String.valueOf(x2));
        if (s1.length() * k1 > s2.length() * k2)
            System.out.println("Greater");
        else if (s1.length() * k1 < s2.length() * k2)
            System.out.println("Less");
        else {
            for (int i = 1; i < k1; i++)
                s1.append(x1);
            for (int i = 1; i < k2; i++)
                s2.append(x2);
            String ans = "Equal";
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    ans = "Greater";
                    break;
                } else if (s1.charAt(i) < s2.charAt(i)) {
                    ans = "Less";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
