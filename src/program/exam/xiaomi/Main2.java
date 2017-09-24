package program.exam.xiaomi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/18.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String string = "";
        while (!(string = in.nextLine()).equals("-")) {
            int index = Integer.parseInt(string.substring(string.indexOf(" ") + 1));
            String s = string.substring(0, string.indexOf(" "));
            map.put(s, index);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            int max = 0, ans = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int tmp = help(entry.getKey(), s);
                if (tmp > max) {
                    max = tmp;
                    ans = entry.getValue();
                }

            }
            System.out.println(ans);
        }
    }

    public static int help(String pre, String s) {
        if (!s.startsWith(pre))
            return 0;
        int start = pre.length();
        if (start >= s.length() || s.charAt(start) == '/')
            return pre.length();
        return 0;
    }
}
