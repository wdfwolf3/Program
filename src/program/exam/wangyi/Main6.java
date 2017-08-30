package program.exam.wangyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            int ans = 1, cur = 1;
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) != string.charAt(i - 1))
                    cur++;
                else if (cur != 1) {
                    ans = Math.max(ans, cur);
                    cur = 1;
                }
            }
            System.out.println(Math.max(ans, cur));
        }
    }

}
