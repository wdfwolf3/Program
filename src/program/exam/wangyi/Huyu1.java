package program.exam.wangyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/16.
 */
public class Huyu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String[] strings = new String[t];
        for (int i = 0; i < t; i++)
            strings[i] = adapt(in.nextLine());
        for (int i = 0; i < t; i++)
            System.out.println(strings[i]);
    }

    public static String adapt(String s) {
        String[] strings = s.split(":");
        char[] chars = s.toCharArray();
        if (Integer.parseInt(strings[0]) > 23)
            chars[0] = '0';
        if (Integer.parseInt(strings[1]) > 59)
            chars[3] = '0';
        if (Integer.parseInt(strings[2]) > 59)
            chars[6] = '0';
        return new String(chars);
    }
}
