package program.exam.lianjia;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wdfwolf3 on 2017/8/19.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        System.out.println(set.size());
        String ans = "";
        for (Integer i : set) {
            ans += (i + " ");
        }
        System.out.println(ans.substring(0, ans.length() - 1));
    }
}
