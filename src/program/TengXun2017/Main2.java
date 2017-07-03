package program.TengXun2017;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/7/2.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (first < 1 || first > 1024 || second < 1 || second > 1024) {
                System.out.println(-1);
                continue;
            }
            int[] search = new int[32];
            search[(first - 1) / 32] = search[(first - 1) / 32] | (1 << ((first - 1) % 32));
            boolean ans = (search[(second - 1) / 32] & (1 << ((second - 1) % 32))) == 0;
            System.out.println(ans ? 0 : 1);
        }
    }
}
