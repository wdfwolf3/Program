package program.exam.didi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            if (nums[i] == nums[i2] * 2)
                i2++;
            if (nums[i] == nums[i3] * 3)
                i3++;
            if (nums[i] == nums[i5] * 5)
                i5++;
        }
        System.out.println(nums[n - 1]);
    }
}
