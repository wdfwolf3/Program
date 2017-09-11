package program.offer;

/**
 * Created by wdfwolf3 on 2017/8/30.
 */
public class InversePairs {
    public static final int mod = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2)
            return 0;
        return help(array, 0, array.length - 1);
    }

    public int help(int[] array, int l, int r) {
        if (r - l < 1)
            return 0;
        else if (r - l == 1)
            if (array[r] < array[l]) {
                int tmp = array[r];
                array[r] = array[l];
                array[l] = tmp;
                return 1;
            } else
                return 0;
        int mid = (l + r) / 2, ans = (help(array, l, mid) + help(array, mid + 1, r)) % mod;
        int[] tmp = new int[r - l + 1];
        int i = mid, j = r, k = r - l, count = r - mid;
        while (i >= l && j >= mid + 1)
            if (array[i] > array[j]) {
                ans = (ans + count) % mod;
                tmp[k--] = array[i--];
            } else {
                count--;
                tmp[k--] = array[j--];
            }
        if (i < l)
            for (int m = mid + 1; m <= j; m++)
                array[l++] = array[m];
        else
            l = i + 1;
        for (int m = k + 1; m < tmp.length; m++)
            array[l++] = tmp[m];
        return ans;
    }

    public static void main(String[] args) {
        int[] nusm = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new InversePairs().InversePairs(nusm));
    }
}
