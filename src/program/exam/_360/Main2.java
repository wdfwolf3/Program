package program.exam._360;

import java.util.Scanner;

/**
 * 给定一个数组，找出每个元素之前，比它大的元素个数
 * 元素大小[1,200000]
 * 输入
 * 5
 * 4 5 2 3 1
 * 输出
 * 0 0 2 2 4
 * <p>
 * Created by wdfwolf3 on 2017/8/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.print(0);
        if (n > 200000) {
            int[] sign = new int[200001];
            sign[nums[0]] = 1;
            for (int i = 1; i < n; i++) {
                int count = 0;
                for (int j = nums[i]; j < 200001; j++) {
                    count += sign[j];
                }
                sign[nums[i]] += 1;
                System.out.print(" " + count);
            }
        } else {
            for (int i = 1; i < n; i++) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i])
                        count++;
                }
                System.out.print(" " + count);
            }
        }
    }
}
