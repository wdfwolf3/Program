package program.exam.lianjia;

/**
 * 一串首尾相连的珠子(m个)，有N种颜色(N<=10)，
 * 设计一个算法，取出其中一段，要求包含所有N中颜色，并使长度最短。
 * 并分析时间复杂度与空间复杂度。
 */
public class MinLengthAllColors {
    public int min(int[] nums, int m, int n) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] newm = new int[m * 2];
        for (int i = 0; i < m; i++)
            newm[i] = newm[i + m] = nums[m];
        int[] count = new int[n];
        int j = 0, num = 0;
        while (num < n) {
            count[newm[j]]++;
            if (count[newm[j++]] == 1)
                num++;
        }
        num = j;
        m *= 2;
        for (int i = 0; i < m; i++, j++) {
            while (count[newm[i]]-- == 1)
                i++;
            if (m + 1 == j)
                break;
            num = Math.min(num, j - i);
            for (; j < m; j++) {
                count[newm[j]]++;
                if (count[newm[j]] == 1)
                    break;
            }
        }
        return num;
    }
}
