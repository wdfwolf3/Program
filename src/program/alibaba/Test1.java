package program.alibaba;

import java.util.*;

/**
 * Created by wdfwolf3 on 2017/7/15.
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();

        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        res = guessMyPath(dimList);
        System.out.println(res);
    }

    public static Long guessMyPath(List<Long[]> dimList) {
        Long[][] distance = new Long[dimList.size() + 1][dimList.size() + 1];
        Long[] mine = {0l, 0l, 0l, 0l, 0l};
        for (int i = 1; i <= dimList.size(); i++) {
            distance[0][i] = help(mine, dimList.get(i - 1));
            distance[i][0] = distance[0][i];
        }
        for (int i = 1; i <= dimList.size(); i++) {
            for (int j = i + 1; j <= dimList.size(); j++) {
                distance[i][j] = help(dimList.get(i - 1), dimList.get(j - 1));
                distance[j][i] = distance[i][j];
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < dimList.size(); i++) {
            set.add(i);
        }
        Long ans = 0l;
        int p = 0;
        for (int i = 0; i < dimList.size(); i++) {
            Long max = Long.MAX_VALUE;
            int index = 1;
            for (Integer integer : set) {
                if (max > distance[p][integer + 1]) {
                    max = distance[p][integer + 1];
                    index = integer;
                }
            }
            set.remove(index);
            p = index + 1;
            ans += max;
        }
        ans += distance[0][p];
        return ans;
    }

    public static Long help(Long[] dim1, Long[] dim2) {
        return Math.abs(dim1[0] - dim2[0]) + Math.abs(dim1[1] - dim2[1]) + Math.abs(dim1[2] - dim2[2]) + 10 * Math.abs(dim1[3] - dim2[3]) + 100 * Math.abs(dim1[4] - dim2[4]);
    }
}
