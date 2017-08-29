package program.souhu;

import java.util.Scanner;

/**
 * Kolakoski(构造序列)，n为输出前n项，m为使用的数字个数
 * 输入
 * n m
 * m个数字
 * 输出
 * n行结果
 * <p>
 * Created by wdfwolf3 on 2017/8/28.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++)
            nums[i] = in.nextInt();
        int i = 2, count = 0, mi = 1;
        int[] ints = new int[n];
        for (int j = 0; j < nums[0] && count < n; j++)
            ints[count++] = nums[0];
        int j = count != 1 ? ints[1] : nums[1];
        for (; count < n; mi++) {
            int tmp = nums[mi % m];
            for (int k = 0; k < j && count < n; k++)
                ints[count++] = tmp;
            if (count == n)
                break;
            j = ints[i++];
        }
        for (j = 0; j < n; j++)
            System.out.println(ints[j]);
    }
}
