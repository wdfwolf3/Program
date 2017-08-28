package program.sort;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        QuickSort quickSort = new QuickSort();
        int[] nums = {6, 2, 7, 3, 3, 3, 3, 8, 9, 4, 3, 6, 5};
//        quickSort.quickSort(nums);
//        InsertSort.insertSort(nums);
//        BubbleSort.bubbleSort(nums);
//        SelectSort.selectSort(nums);
//        nums = MergeSort.mergeSort(nums);
        HeapSort.createMaxHeap(nums);
        HeapSort.heapSortDec(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();
        System.out.println(BinarySearch.lowestBinarySearch(nums, 10));
        System.out.println(BinarySearch.highestBinarySearch(nums, 3));
        System.out.println(BinarySearch.binarySearch(nums, 7));
        System.out.println(BinarySearch.binarySearch(nums, 7, 0, 5));
    }
}
