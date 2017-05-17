package program.sort;

/**
 * 从头开始遍历数组得到最小数及其下标,和第一个元素交换,继续操作
 *
 * Created by wendefeng on 2017/1/19.
 */
public class SelectSort {
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i, minValue = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(minValue > nums[j]){
                    minIndex = j;
                    minValue = nums[j];
                }
            }
            if(minIndex!=i)
                QuickSort.swap(nums, i, minIndex);
        }
    }
}
