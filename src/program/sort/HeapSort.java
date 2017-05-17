package program.sort;

/**
 *
 * Created by wendefeng on 2017/1/19.
 */
public class HeapSort {
    /**
     * 数组通过下标模拟成二叉堆,i节点的孩子节点分别为2i+1和2i+2,i节点的父节点为(i-1)/2
     * 最后一个度不为0的节点为(nums.length-1)/2
     *
     * @param nums
     */
    //
    public static void heapSortInc(int[] nums){
        HeapSort heapSort = new HeapSort();
//        heapSort.createMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            QuickSort.swap(nums, 0, i);
            heapSort.adjustMaxHeap(nums, i-1);
        }
    }

    public static void heapSortDec(int[] nums){
        HeapSort heapSort = new HeapSort();
        heapSort.createMinHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            QuickSort.swap(nums, 0, i);
            heapSort.adjustMinHeap(nums, i-1);
        }
    }

//    public void createMaxHeap(int[] nums){
//        for (int i = (nums.length-2)/2; i >= 0; i--) {
//            adjustMaxHeap(nums, );
//        }
//    }
    public void createMinHeap(int[] nums){

    }

    public void adjustMaxHeap(int[] nums, int limit){

    }

    public void adjustMinHeap(int[] nums, int limit){

    }
}
