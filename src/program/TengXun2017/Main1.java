package program.TengXun2017;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/7/2.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = {16276, 651, 26, 1};
        while (sc.hasNext()) {
            String str = sc.next();
            int index = 0;
            int length = str.length();
            for (int i = 4; i > 0; i--) {
                if (length - i < 0)
                    continue;
                char c = str.charAt(length - i);
                index += ((c - 'a') * x[length - i] + 1);
            }
            System.out.println(index - 1);
        }
    }
}
