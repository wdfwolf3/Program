package program.exam.wangyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] ans = new int[n];
            if (n % 2 == 0) {
                int mid = (n - 1) / 2;
                for (int i = 0; i <= (n - 1) / 2; i++) {
                    ans[mid + i + 1] = in.nextInt();
                    ans[mid - i] = in.nextInt();
                }
            } else {
                ans[n / 2] = in.nextInt();
                int mid = n / 2;
                for (int d = 1; d <= (n - 1) / 2; d++) {
                    ans[mid + d] = in.nextInt();
                    ans[mid - d] = in.nextInt();
                }
            }
            for (int i = 0; i < n; i++)
                if (i == n - 1)
                    System.out.println(ans[i]);
                else
                    System.out.print(ans[i] + " ");
        }
    }
}
