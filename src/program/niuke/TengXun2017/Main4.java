package program.niuke.TengXun2017;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/7/2.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String ans = "";
            int left = -90, right = 90;
            for (int i = 0; i < 6; i++) {
                int middle = (left + right) / 2;
                if (n < middle) {
                    ans += "0";
                    right = middle;
                } else {
                    ans += "1";
                    left = middle;
                }
            }
            System.out.println(ans);
        }
    }
}
