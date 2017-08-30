package program.offer;

/**
 * Created by wdfwolf3 on 2017/8/30.
 */
public class NumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cur = n % 10, mul = 1, ans = 0, low = 0;
        while (n != 0) {
            n /= 10;
            if (cur > 1)
                ans += (n + 1) * mul;
            else {
                ans += n * mul;
                ans += (cur == 0) ? 0 : (low + 1);
            }
            low += mul * cur;
            cur = n % 10;
            mul *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 9, 10, 15, 26, 100, 250, 135, 114};
        for (int i = 0; i < n.length; i++) {
            System.out.println(new NumberOf1().NumberOf1Between1AndN_Solution(n[i]));


        }
    }
}
