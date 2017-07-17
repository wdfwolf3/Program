package program.sort;

/**
 * program.sort.QuickSort 快速排序
 * 给定数组借助辅助排序函数(增加左右边界下标)排序
 * <p>
 * Created by Fung on 2017/1/16.
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        quickSortAssist(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

    /**
     * 1.取数组左边界值为povit为参考值,每次循环先从右游标开始左移,遇到第一个比povit小的值交换左右游标值,
     * 再从左游标开始右移,遇到第一个比povit大于等于的值交换左右游标值.重复这个步骤直到游标相遇.
     * 2.再以l=r为界限对左右两个数组重复排序过程.
     *
     * @param nums       待排序数组
     * @param left,right 左右边界
     */
    public static void quickSortAssist(int[] nums, int left, int right) {
        if (left == right)
            return;
        //l,r左右指针，povit为比较参考值
        int l = left, r = right, povit = nums[l];
        while (l < r) {
            while (l < r && povit <= nums[r]) {
                r--;                  //左移右下标,下面同理
            }
            if (l == r)
                break;
            swap(nums, l++, r);
            while (l < r && povit >= nums[l]) {
                l++;
            }
            if (l == r)
                break;
            swap(nums, l, r--);
        }
        if (--l > left)                 //如果左边还有未排序子数组,则对其排序,下面同理
            quickSortAssist(nums, left, l);
        if (++r < right)
            quickSortAssist(nums, r, right);
    }

    /**
     * 交换数组两个位置的值
     *
     * @param nums 原始数组
     * @param m,n  需要交换的两个下标
     */
    public static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
