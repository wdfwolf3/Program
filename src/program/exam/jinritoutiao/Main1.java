package program.exam.jinritoutiao;

import java.util.*;

/**
 * 给一个二维平面，而且横纵坐标都不会重复（简化了排序），要求“不存在左上方还有点”的点集。
 * 数据量最大是50W，所以基本上用是O(nlogn)的方法解决。
 * Created by wdfwolf3 on 2017/8/22.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o1[1] <= o2[1] ? (o1[1] == o2[1] ? 0 : 1) : -1;
                return o1[0] <= o2[0] ? (o1[0] == o2[0] ? i : -1) : 1;
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = n - 1, max = Integer.MIN_VALUE; i >= 0; i--)
            if (max <= nums[i][1]) {
                max = nums[i][1];
                list.add(nums[i]);
            }
        for (int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
    }
}
