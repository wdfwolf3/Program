package program.wangyi;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mod = 1000000007;
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i <= k; i++)
                dp[1][i] = 1;
            for (int i = 1; i <= n; i++)
                dp[i][1] = 1;
            for (int i = 2; i <= n; i++) {
                int sum = 1;
                for (int j = 2; j <= k; j++)
                    sum = (sum + dp[i - 1][j]) % mod;
                for (int j = 2; j <= k; j++) {
                    int dec = 0;
                    for (int l = j * 2; l <= k; l += j)
                        dec = (dec + dp[i - 1][l]) % mod;
                    dp[i][j] = (sum - dec) % mod;
                }
            }
            int ans = 0;
            for (int i = 1; i <= k; i++)
                ans = (ans + dp[n][i]) % mod;
            System.out.println(ans);
        }
    }
}
