package program.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            Set<Character> set = new HashSet<>();
            for (char c : string.toCharArray())
                set.add(c);
            if (set.size() > 2)
                System.out.println(0);
            else if (set.size() == 2)
                System.out.println(2);
            else
                System.out.println(1);
        }
    }
}
