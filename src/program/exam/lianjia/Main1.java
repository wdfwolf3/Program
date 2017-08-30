package program.exam.lianjia;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        nums[0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + in.nextInt();
        }
        int q = in.nextInt();
        int[] qi = new int[q];
        for (int i = 0; i < q; i++) {
            qi[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                if (qi[i] <= nums[j]) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
