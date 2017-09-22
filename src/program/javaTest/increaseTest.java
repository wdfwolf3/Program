package program.javaTest;

public class increaseTest {
    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        int i = 0;
        while (nums[i]-- != 4) {
            System.out.println(i++);
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }
}
