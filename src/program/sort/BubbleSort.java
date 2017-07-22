package program.sort;

/**
 * Created by wendefeng on 2017/1/19.
 */
public class BubbleSort {
    /**
     * 每次从开始比较得到最大值放在最后位置
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (nums[j] > nums[j + 1])
                    QuickSort.swap(nums, j, j + 1);
    }
}
