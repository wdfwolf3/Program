package program.exam.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int ans = 0, tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp ^= nums[i];
            if (!set.contains(tmp))
                set.add(tmp);
            else {
                ans++;
                set = new HashSet<>();
                set.add(0);
                tmp = 0;
            }
        }
        System.out.println(ans);
    }
}
