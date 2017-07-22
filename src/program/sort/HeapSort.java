package program.sort;

/**
 * Created by wendefeng on 2017/1/19.
 */
public class HeapSort {
    /**
     * 数组通过下标模拟成二叉堆,i节点的孩子节点分别为2i+1和2i+2,i节点的父节点为(i-1)/2
     * 最后一个度不为0的节点为(nums.length-2)/2
     *
     * @param nums
     */
    public static void heapSortInc(int[] nums) {
        HeapSort heapSort = new HeapSort();
        createMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            adjustMaxHeap(nums, 0, i);
            QuickSort.swap(nums, 0, i);
        }
    }

    /**
     * 数组通过下标模拟成二叉堆,i节点的孩子节点分别为2i+1和2i+2,i节点的父节点为(i-1)/2
     * 最后一个度不为0的节点为(nums.length-2)/2
     *
     * @param nums
     */
    public static void heapSortDec(int[] nums) {
        HeapSort heapSort = new HeapSort();
        createMinHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            adjustMinHeap(nums, 0, i);
            QuickSort.swap(nums, 0, i);
        }
    }

    /**
     * 从最后一个非叶子节点开始调整堆
     *
     * @param nums
     */
    public static void createMaxHeap(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--)
            adjustMaxHeap(nums, i, nums.length - 1);
    }

    /**
     * 从最后一个非叶子节点开始调整堆
     *
     * @param nums
     */
    public static void createMinHeap(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0; i--)
            adjustMinHeap(nums, i, nums.length - 1);
    }

    /**
     * 对数组index进行调整，使其满足大根堆
     *
     * @param nums
     * @param index     待调整的元素下标
     * @param lastIndex 待调整数组的最后下标，lastIndex之后的元素已排序
     */
    public static void adjustMaxHeap(int[] nums, int index, int lastIndex) {
        while (index <= (lastIndex - 1) / 2) {
            int maxSon = 2 * index + 1;
            if (maxSon + 1 <= lastIndex && nums[maxSon] < nums[maxSon + 1])
                maxSon++;
            if (nums[index] >= nums[maxSon])
                return;
            else {
                int tmp = nums[index];
                nums[index] = nums[maxSon];
                nums[maxSon] = tmp;
                index = maxSon;
            }
        }
    }

    /**
     * 对数组index进行调整，使其满足小根堆
     *
     * @param nums
     * @param index     待调整的元素下标
     * @param lastIndex 待调整数组的最后下标，lastIndex之后的元素已排序
     */
    public static void adjustMinHeap(int[] nums, int index, int lastIndex) {
        while (index <= (lastIndex - 1) / 2) {
            int minSon = 2 * index + 1;
            if (minSon + 1 <= lastIndex && nums[minSon] > nums[minSon + 1])
                minSon++;
            if (nums[index] <= nums[minSon])
                return;
            else {
                int tmp = nums[index];
                nums[index] = nums[minSon];
                nums[minSon] = tmp;
                index = minSon;
            }
        }
    }
}
