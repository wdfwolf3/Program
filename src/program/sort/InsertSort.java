package program.sort;

/**
 * Created by wendefeng 2017/1/19.
 */
public class InsertSort {
    /**
     * 从后边开始比较直接可以移动;二分查找快,然后整体移动
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0) {
                if (temp < nums[j])
                    nums[j + 1] = nums[j];
                else
                    break;
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
