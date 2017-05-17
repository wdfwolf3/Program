package program.sort;

/**
 * Created by wendefeng on 2017/1/19.
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            for (int j = 0; j < i; j++) {
               if(nums[j] > nums[j+1])
                   QuickSort.swap(nums, j, j+1);
            }
        }
    }
}
