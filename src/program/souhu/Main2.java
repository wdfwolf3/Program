package program.souhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 6*6的箱子，装1*1，2*2，3*3，4*4，5*5,6*6的箱子，高度都相同。最少用多少个箱子
 * 输入
 * 6个数字代表分别有多少个
 * 输出
 * 最少需要多少个箱子
 * <p>
 * Created by wdfwolf3 on 2017/8/28.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = "";
        List<Integer> ans = new ArrayList<>();
        while (!(string = in.nextLine()).equals("0 0 0 0 0 0")) {
            String[] strings = string.split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++)
                nums[i] = Integer.parseInt(strings[i]);
            int count = nums[5] + nums[4] + nums[3] + (nums[2] + 3) / 4;
            int shengyu2 = nums[3] * 5, shengyu3 = 4 - nums[2] % 4, shengyu1 = nums[4] * 11;
            switch (shengyu3) {
                case 3:
                    shengyu2 += 5;
                    shengyu1 += 7;
                    break;
                case 2:
                    shengyu2 += 3;
                    shengyu1 += 6;
                    break;
                case 1:
                    shengyu2 += 1;
                    shengyu1 += 5;
                    break;
                default:
                    break;
            }
            if (nums[1] > shengyu2) {
                nums[1] -= shengyu2;
                count += (nums[1] + 8) / 9;
                shengyu1 += 36 - (nums[1] % 9) * 4;

            } else {
                nums[1] = 0;
                shengyu2 -= nums[1];
                shengyu1 += 4 * shengyu2;
            }
            nums[0] -= shengyu1;
            if (nums[0] > 0)
                count += (nums[0] + 35) / 36;
            ans.add(count);
        }
        for (Integer i : ans)
            System.out.println(i);
    }
}
