package program.exam.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = in.nextInt();
            if (n < 3) {
                System.out.println("Possible");
                continue;
            }
            Arrays.sort(nums);
            int d = nums[1] - nums[0];
            boolean ans = true;
            for (int i = 2; i < n; i++)
                if (nums[i] - nums[i - 1] != d) {
                    ans = false;
                    break;
                }
            System.out.println(ans ? "Possible" : "Impossible");
        }
    }
}
