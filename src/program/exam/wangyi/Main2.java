package program.exam.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            List<Integer> listx = new ArrayList<>();
            List<Integer> listy = new ArrayList<>();
            int[] xi = new int[n];
            int[] yi = new int[n];
            for (int i = 0; i < n; i++) {
//                listx.add(in.nextInt());
                xi[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
//                listy.add(in.nextInt());
                yi[i] = in.nextInt();
            }
            String ans = "0 ";
            for (int i = 1; i < n; i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < n - i; j++) {
                    tmp = Math.min(tmp, help(Arrays.copyOfRange(xi, j, j + i + 1), Arrays.copyOfRange(yi, j, j + i + 1)));
                }
                ans += (tmp + " ");
            }
            System.out.println(ans.substring(0, ans.length() - 1));
        }
    }

    public static int help(int[] listx, int[] listy) {
        Arrays.sort(listx);
        Arrays.sort(listy);
//        Collections.sort(listx);
//        Collections.sort(listy);
        int x = listx[listx.length / 2], y = listy[listy.length / 2];
//        int x = listx.get(listx.size()/2), y = listy.get(listy.size()/2);
        int ans = 0;
        for (int i = 0; i < listx.length; i++) {
            ans += Math.abs(listx[i] - x);
            ans += Math.abs(listy[i] - y);
        }
        return ans;
    }
}
