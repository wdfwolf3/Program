package program.exam.lianjia;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = in.nextInt();
        }
        int n = in.nextInt() + 30, ans = 0;
        for (int i = 0; i < 10; i++) {
            if (nums[i] <= n)
                ans++;
        }
        System.out.println(ans);
    }
}
