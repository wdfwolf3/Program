package program.exam.aiqiyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
//        double logn  = Math.log(n),logm = Math.log(m);
//        int min = Math.min(n,m), ans = min + (int)Math.sqrt(m)+ (int)Math.sqrt(n)-2;
//        for (int i = 2; i <= min; i++) {
//            double logi = (Math.log(i));
//            int tmpn = (int) (logn/logi),tmpm = (int) (logm/logi);
//            ans += (tmpm-1)/2;
//            ans += (tmpn-1)/2;
//        }


        int ans = Math.min(n, m) + (int) Math.sqrt(m) + (int) Math.sqrt(n) - 2, sqrtm = (int) Math.sqrt(m);
        for (int i = 2; i <= sqrtm; i++) {
            int tmpm = m / (i * i);
            for (int j = 2; j <= n && j <= tmpm; j++) {
                int tmp = (int) (Math.log(tmpm) / Math.log(j));
                ans += (tmp + 1) / 2;
            }
        }
        int sqrtn = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtn; i++) {
            int tmpm = n / (i * i);
            for (int j = 2; j <= m && j <= tmpm; j++) {
                int tmp = (int) (Math.log(tmpm) / Math.log(j));
                ans += (tmp + 1) / 2;
            }
        }


//        for (int i = 2; i <= max; i++) {
//            int tar = i*i;
//            for (int j = 1; j < i; j++) {
//                if (tar%j==0){
//                    int tmp = tar/j;
//                    if (j<=n && tmp <=m)
//                        ans++;
//                    if (j<=m && tmp <=n)
//                        ans++;
//                }
//            }
////            if (i<=m && i <=n)
////                ans++;
//        }
        System.out.println(ans);
    }
}
