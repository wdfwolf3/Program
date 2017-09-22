package program.exam._360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * n个A物品，m个B物品，用a个A加b个B打包一盒卖x， c个B打包卖y， d个A打包卖z，最多卖多少钱
 * 输入
 * n m
 * a b c d
 * x y z
 * 输出
 * max
 * <p>
 * Created by wdfwolf3 on 2017/8/26.
 */
public class Main1 {
    public static int n, m, a, b, c, d, x, y, z;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        d = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(help(n, m, dp));
    }

    public static int help(int n, int m, int[][] dp) {
        if (dp[n][m] > -1)
            return dp[n][m];
        int ans = 0;
        if (n >= d)
            ans = help(n - d, m, dp) + z;
        if (m >= c)
            ans = Math.max(ans, help(n, m - c, dp) + y);
        if (n >= a && m >= b)
            ans = Math.max(ans, help(n - a, m - b, dp) + x);
        dp[n][m] = ans;
        return ans;
    }
}
