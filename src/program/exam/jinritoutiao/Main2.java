package program.exam.jinritoutiao;

import java.util.Scanner;

/**
 * 一段长度是50W的数列，找一段区间，使得：这段区间里的最小值*这段区间值的总和最大。
 * 换句话说就是：min*total是全部区间里最大的。
 * <p>
 * Created by wdfwolf3 on 2017/8/22.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i], sum = nums[i];
            ans = Math.max(ans, min * sum);
            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                sum += nums[j];
                ans = Math.max(ans, min * sum);
            }
        }
        System.out.println(ans);
    }
}
