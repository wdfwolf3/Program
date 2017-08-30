package program.tengxun;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/8/29.
 */
public class Moni {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        int root = (int) Math.pow(2, k - 1), dec = (int) Math.pow(2, k - 2);
        while (root != x && root != y && root != z) {
            if (x > root && y > root && z > root)
                root += dec;
            else if (x < root && y < root && z < root)
                root -= dec;
            else
                break;
            dec /= 2;
        }
        System.out.println(root);
    }
}
