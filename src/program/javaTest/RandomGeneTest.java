package program.javaTest;

import java.util.Random;

/**
 * Created by admin on 2017/1/16.
 */
public class RandomGeneTest {
    public static void main(String[] args) {
        //伪随机，seed不变得到的序列不变
        Random random0 = new Random(10);
        int[] nums0 = new int[10];
        for (int i = 0; i < 10; i++) {
            nums0[i] = random0.nextInt(10);
            System.out.println(nums0[i]);
        }


        int[] nums = new int[10000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++)
            nums[i] = 1 + (int) Math.random() * (10000000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        Random random = new Random();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++)
            nums[i] = random.nextInt(10000000);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        boolean isExist = false;
        int target = 3487594;
        long start3 = System.currentTimeMillis();
        int[] flag = new int[target];
        for (int i = 0; i < 10000000; i++) {
            if (nums[i] >= target)
                continue;
            else {
                if (flag[target - nums[i]] == 1) {
                    isExist = true;
                    break;
                } else
                    flag[nums[i]] = 1;
            }
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);
        System.out.println(isExist);
    }
}

