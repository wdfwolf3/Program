package program.offer;

/**
 * Created by Fung on 2017/7/5.
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = new int[100000000];
        for (int i = 0; i < 2342348; i++) {
            array[i] = i + 10000000 - 2342348;
        }
        for (int i = 2342348; i < 10000000; i++) {
            array[i] = i - 2342348;
        }
        long l = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
//        }
//        System.out.println(System.currentTimeMillis() - l);
        l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(new MinNumberInRotateArray().minNumberInRotateArray1(array));
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    public int minNumberInRotateArray(int[] array) {

        if (array.length == 0)
            return 0;
        int left = 0, right = array.length - 1, ans = Integer.MAX_VALUE;
        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] > array[right])
                left = middle + 1;
            else if (array[middle] < array[left])
                right = middle;
            else if (array[left] == array[right]) {

                return array[left];
            } else
                right = middle;
        }
        return Math.min(ans, array[left]);

    }

    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0)
            return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[0];
    }
}
