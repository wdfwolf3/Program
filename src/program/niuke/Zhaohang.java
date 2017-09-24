package program.niuke;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/14.
 */
public class Zhaohang {
    public static int[][] nums = new int[26][26];
    public static boolean[] flag = new boolean[26];
    public static int[] ans = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            char[] chars = sc.nextLine().toCharArray();
            if (chars[2] != '*')
                nums[chars[0] - 'A'][chars[2] - 'A'] = 1;
            if (chars[4] != '*')
                nums[chars[0] - 'A'][chars[4] - 'A'] = 1;
        }
        for (int i = 0; i < 26; i++)
            if (!flag[i])
                DFS(i);
        String s = "";
        for (int i = 0; i < 26; i++)
            if (ans[i] >= n)
                s+=(" " + (char)(i+'A'));
        System.out.println(s.substring(1));
    }

    public static int DFS(int index) {
        int count = 0;
        flag[index] = true;
        for (int i = 0; i < 26; i++)
            if (!flag[i] && nums[index][i] == 1)
                count += DFS(i)+1;
        ans[index] = count;
        return count;
    }
}
