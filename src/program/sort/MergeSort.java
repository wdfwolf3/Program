package program.sort;

/**
 * Created by wendefeng on 2017/1/19.
 */
public class MergeSort {
    /**
     * 归并排序，对整个nums数组排序
     *
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {
        MergeSort mergeSort = new MergeSort();
        return mergeSort.mergeSortIndex(nums, 0, nums.length - 1);
    }

    /**
     * 对数组中特定范围内的元素归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int[] mergeSortIndex(int[] nums, int left, int right) {
        //一个元素
        if (left == right)
            return new int[]{nums[left]};
        //两个元素
        if (left + 1 == right) {
            return new int[]{Math.min(nums[left], nums[right]), Math.max(nums[left], nums[right])};
        }
        int middle = (left + right) / 2;
        int[] temp1 = mergeSortIndex(nums, left, middle);
        int[] temp2 = mergeSortIndex(nums, middle + 1, right);
        return mergeTwoSortedArrays(temp1, temp2);
    }

    /**
     * 合并两个已排序的数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; i < nums1.length || j < nums2.length; k++) {
            if (i == nums1.length)
                result[k] = nums2[j++];
            else if (j == nums2.length)
                result[k] = nums1[i++];
            else if (nums1[i] <= nums2[j])
                result[k] = nums1[i++];
            else
                result[k] = nums2[j++];
        }
        return result;
    }
}
