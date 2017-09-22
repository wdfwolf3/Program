package program.exam.aiqiyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                tmp++;
            else {
                ans = Math.max(ans, tmp);
                tmp--;
            }
        }
        System.out.println(ans);
    }
}
