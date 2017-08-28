package program.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        int k = in.nextInt();
        String[] strings = string.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++)
            nums[i] = Integer.parseInt(strings[i]);
        Arrays.sort(nums);
        System.out.println(nums[nums.length - k]);
    }
}
