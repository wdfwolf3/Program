package program.exam.jingdong.xiaozhao;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/8.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(help(s));

    }

    public static int help(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int f = i;
                while (s.charAt(f++) == '(')
                    l++;
                i = f - 1;
            } else {
                int r = 0;
                while (i < s.length() && s.charAt(i) == ')') {
                    i++;
                    r++;
                }

                if (r == l)
                    return r * help(s.substring(i));
                else
                    break;
            }
        }
        int ans = 1;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ')') {
                int f = i;
                int r = 0;
                while (i < s.length() && s.charAt(i) == ')') {
                    r++;
                    i++;
                }
                ans += r * help(s.substring(1, i - 1) + s.substring(i));
            } else
                i++;
        }
        return ans;
    }
}
