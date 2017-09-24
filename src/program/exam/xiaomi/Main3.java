package program.exam.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/18.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] map = new char[26];
        for (int i = 0; i < 26; i++) {
            map[i] = (char) ('a' + i);
        }
        while (in.hasNext()) {
            List<String> pre = new ArrayList<>();
            List<String> cur = new ArrayList<>();
            char[] chars = in.nextLine().toCharArray();
            cur.add(String.valueOf(map[chars[0] - '1']));
            pre.add("");
            for (int i = 1; i < chars.length; i++) {
                int p = chars[i - 1] - '0', c = chars[i] - '0', tmp = p * 10 + c;
                List<String> copy = new ArrayList<>(cur);
                for (int j = 0; j < cur.size(); j++) {
                    cur.set(j, cur.get(j) + map[chars[i] - '1']);
                }
                if (tmp <= 26) {
                    for (int j = 0; j < pre.size(); j++) {
                        cur.add(pre.get(j) + map[tmp - 1]);
                    }
                }
                pre = copy;
            }
            StringBuilder stringBuilder = new StringBuilder();
            Collections.sort(cur);
            for (String s : cur)
                stringBuilder.append(" " + s);
            System.out.println(stringBuilder.toString().substring(1));
        }
    }
}
