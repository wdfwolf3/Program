package program.sort;

/**
 * program.sort.BinarySearch,二分查找
 *
 * Created by Fung on 2017/1/16.
 */
public class BinarySearch {
    /**
     * 非递归二分查找,不断更新左右下标.
     *
     * @param nums    目标数组
     * @param target  目标数
     * @return        返回查找的下标,没有查找到返回0
     */
    public static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left<right){
            int middle = (left+right)/2;
            if(nums[middle] == target){
                return middle;
            }else if (nums[middle] > target){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return (nums[left]==target)?left:-1;
    }

    /**
     * 递归二分查找,根据中间数与目标数比较结果,缩小待查数组范围
     *
     * @param nums        目标数组
     * @param target      目标数
     * @param left,right  待查子数组左右下标
     * @return            返回查找的下标,没有查找到返回0
     */
    public static int binarySearch(int[] nums, int target, int left, int right){
        if(left == right){
            return (nums[left]==target)?left:-1;
        }
        int middle = (left + right) / 2;
        if(nums[middle] == target)
            return middle;
        else if (nums[middle] > target)
            return binarySearch(nums, target, left, middle-1);
        else
            return binarySearch(nums, target, middle+1, right);
    }

    /**
     * 当有多个元素等于目标数时,返回最小的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int lowestBinarySearch(int[] nums, int target){
       int left = 0, right = nums.length - 1, result = -1;
       while(left < right){
           int middle = (left + right) / 2;
           if (nums[middle] >= target){
               right = middle - 1;
               result = middle;
           }else{
               left = middle + 1;
           }
       }
       return (nums[left]==target)?left:result;
    }

    /**
     * 当有多个元素等于目标数时,返回最大的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int highestBinarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, result = -1;
        while(left < right){
            int middle = (left + right) / 2;
            if (nums[middle] > target){
                right = middle - 1;
            }else{
                result = middle;
                left = middle + 1;
            }
        }
        return (nums[left]==target)?left:result;
    }
}
