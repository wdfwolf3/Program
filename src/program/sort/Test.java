package program.sort;

import java.util.Random;

/**
 * Created by admin on 2017/1/16.
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[10000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
           nums[i] = 1 + (int) Math.random() * (10000000);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Random random = new Random(10000000);
            nums[i] = random.nextInt();
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);

        boolean isExist = false;
        int target = 3487594;
        long start3 = System.currentTimeMillis();
        int[] flag = new int[target];
        for (int i = 0; i < 10000000; i++) {
           if(nums[i] >= target)
               continue;
           else{
               if(flag[target-nums[i]] == 1){
                   isExist = true;
                   break;
               }
               else
                   flag[nums[i]] = 1;
           }
        }
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start3);
        System.out.println(isExist);
    }
}

