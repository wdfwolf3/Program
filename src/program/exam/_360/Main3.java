package program.exam._360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定两个数组，交换两对元素，使数组和的差最小
 * <p>
 * Created by wdfwolf3 on 2017/8/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), suma = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            suma += a[i];
        }
        int m = in.nextInt(), sumb = 0;
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            sumb += b[i];
        }
        int[] newa = new int[n * (n - 1) / 2];
        for (int i = 0, k = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                newa[k++] = a[i] + a[j];
        int[] newb = new int[m * (m - 1) / 2];
        for (int i = 0, k = 0; i < m; i++)
            for (int j = i + 1; j < m; j++)
                newb[k++] = b[i] + b[j];
        Arrays.sort(newa);
        Arrays.sort(newb);
        int s = suma - sumb;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < newa.length; i++) {
            for (int j = 0; j < newb.length; j++) {
                if (Math.abs(s - 2 * (newa[i] - newb[j])) < ans)
                    ans = Math.abs(s - 2 * (newa[i] - newb[j]));
            }
        }
        System.out.println(ans);
    }
}
