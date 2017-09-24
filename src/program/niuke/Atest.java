package program.niuke;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/14.
 */
public class Atest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            nums[i] = num % 7;
            flag[i] = (int) Math.log10(num) + 1;
        }
        int[] sign = new int[11];
        for (int i = 1; i < 11; i++)
            sign[i] = (int) Math.pow(i, 10) % 7;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (((nums[i] * sign[flag[j]]) + nums[j]) % 7 == 0)
                    ans++;
                if (((nums[j] * sign[flag[i]]) + nums[i]) % 7 == 0)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
