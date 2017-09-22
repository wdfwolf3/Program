package program.javaTest;

import java.util.Random;

/**
 * Created by wdfwolf3 on 2017/9/6.
 */
public class BranchPredictionTest {
    public static void main(String[] args) {
        int[] nums = new int[30000];
        Random random = new Random(0);
        for (int i = 0; i < 30000; i++)
            nums[i] = random.nextInt() % 256;
//        Arrays.sort(nums);
        long sum = 0;
        long l = System.nanoTime();
        for (int i = 0; i < 100000; i++)
            for (int j = 0; j < 30000; j++)
                if (nums[j] >= 128)
                    sum += nums[j];
//            {
//                int t = (nums[j] -128)>>31;
//                sum+= ~t&nums[j];
//            }
        System.out.println("sum = " + sum);
        System.out.println((System.nanoTime() - l) / 1000000);
    }
}
