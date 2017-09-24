package program.exam.wangyi;

import java.util.Scanner;

public class Huyu2 {
    private static String word;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[] ans = new int[t];
        for (int i = 0; i < t; i++){
            int n = in.nextInt(), m = in.nextInt(), sum = 0;
            in.nextLine();
            char[][] chars1 = new char[n][m];
            char[][] chars2 = new char[m][n];
            for (int j = 0; j < n; j++) {
                chars1[j] = in.nextLine().toCharArray();
            }
            word = in.nextLine();
            int length = word.length();
            for (int k = 0; m-k >= length; k++) {
                int l = Math.min(n, m-k), p = 0, q=k;
                char[] chars = new char[l];
                for (int j = 0; j < l; j++) {
                    chars[j] = chars1[p++][q++];
                }
                sum+=mat(new String(chars));
            }
            for (int k = 1; n-k >= length; k++) {
                int l = Math.min(m, n-k), q = 0, p=k;
                char[] chars = new char[l];
                for (int j = 0; j < l; j++) {
                    chars[j] = chars1[p++][q++];
                }
                sum+=mat(new String(chars));
            }
            for (int j = 0; j < n; j++)
                sum+=mat(new String(chars1[j]));
            for (int j = 0; j < n; j++)
                for (int k = 0; k < m; k++)
                    chars2[k][j] = chars1[j][k];
            for (int j = 0; j < m; j++)
                sum+=mat(new String(chars2[j]));
            ans[i] = sum;
        }
        for (int i = 0; i < t; i++)
            System.out.println(ans[i]);
    }

    public static int mat(String s){
        int ans = 0, index = s.indexOf(word);
        while (index >= 0){
            index = s.indexOf(word, index+1);
            ans++;
        }
        return ans;
    }
}
