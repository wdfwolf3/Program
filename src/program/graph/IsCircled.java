package program.graph;

public class IsCircled {
    public static boolean isCircled(int[][] nums) {
        int n = nums.length;
        boolean[] sign = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!sign[i]) {
                sign[i] = true;
                for (int j = i + 1; j < n; j++)
                    if (nums[i][j] == 1)
                        if (!dfs(nums, j, i, sign))
                            return false;
            }
        return true;
    }

    public static boolean dfs(int[][] nums, int i, int pre, boolean[] sign) {
        sign[i] = true;
        for (int j = 0; j < nums.length; j++)
            if (nums[i][j] == 1) {
                if (sign[j]) {
                    if (j != pre)
                        return false;
                } else if (!dfs(nums, j, i, sign))
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(isCircled(nums));
    }
}
