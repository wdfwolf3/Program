package program.exam.xiaomi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/18.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] strings = s.split("\\.");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                stringBuilder.append(help(strings[i].toCharArray()));
            }
            stringBuilder.append("_");
            System.out.println(stringBuilder.toString());
        }
    }

    public static String help(char[] chars) {
        StringBuilder s = new StringBuilder();
        int up = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 57) {
                if (up < i)
                    s.append("_" + new String(chars, up, i - up));
                int j = i + 1;
                while (j < chars.length && chars[j] <= 57)
                    j++;
                s.append("_" + new String(chars, i, j - i));
                i = j - 1;
                up = j;
            } else if (chars[i] >= 97) {
                if (i - up > 1) {
                    s.append("_" + new String(chars, up, i - 1 - up));
                    up = i - 1;
                }
                chars[i] -= 32;
                int j = i + 1;
                while (j < chars.length && chars[j] >= 97) {
                    chars[j] -= 32;
                    j++;
                }
                s.append("_" + new String(chars, up, j - up));
                i = j - 1;
                up = j;
            }
        }
        if (up < chars.length)
            s.append("_" + new String(chars, up, chars.length - up));
        ;
        return s.toString();
    }
}
