package program.exam.wangyi;

import java.util.Scanner;

/**
 * Created by wdfwolf3 on 2017/9/16.
 */
public class Huyu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String[] strings = new String[t];
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            String s = in.nextLine();
            strings[i] = s.substring(0,19);
            nums[i] = Integer.parseInt(s.substring(20));
        }
        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            String first = s.substring(0, 19);
            int j = 0, tmp = 0;
            for (; j < t; j++)
                if (com(first, strings[j])<=0)
                    break;
            first = s.substring(20);
            for (; j< t;j++)
                if (com(first, strings[j])<0)
                    break;
                else
                    tmp += nums[j];
            System.out.println(tmp);
        }
//        for (int i = 0; i < m; i++)
//            System.out.println(ans[i]);
    }

    public static int com(String s1, String s2){
        String first = s1.substring(0, 10);
        String[] strings = first.split("/");
        short month1 = Short.parseShort(strings[0]);
        short day1 = Short.parseShort(strings[1]);
        short year1 = Short.parseShort(strings[2]);
        first = s1.substring(11);


        String second = s2.substring(0, 10);
        strings = second.split("/");
        short month2 = Short.parseShort(strings[0]);
        short day2 = Short.parseShort(strings[1]);
        short year2 = Short.parseShort(strings[2]);
        second = s2.substring(11);

        if (year1 < year2)
            return -1;
        else if (year1 > year2)
            return 1;
        if (month1 < month2)
            return -1;
        else if (month1 > month2)
            return 1;
        if (day1 < day2)
            return -1;
        else if (day1 > day2)
            return 1;
        return first.compareTo(second);
    }
}

class Time implements Comparable{
    private short year;
    private short month;
    private short day;
    private short hour;
    private short minute;
    private short second;
    public int m;

    public Time(String s1, String s2, String s3){
        String[] strings = s1.split("/");
        month = Short.parseShort(strings[0]);
        day = Short.parseShort(strings[1]);
        year = Short.parseShort(strings[2]);
        strings = s2.split(":");
        hour = Short.parseShort(strings[0]);
        minute = Short.parseShort(strings[1]);
        second = Short.parseShort(strings[2]);
    }

    @Override
    public int compareTo(Object o) {
        Time time = (Time) o;
        if (year < time.year)
            return -1;
        else if (year > time.year)
            return 1;
        if (month < time.month)
            return -1;
        else if (month > time.month)
            return 1;
        if (day < time.day)
            return -1;
        else if (day > time.day)
            return 1;
        if (hour < time.hour)
            return -1;
        else if (hour > time.hour)
            return 1;
        if (minute < time.minute)
            return -1;
        else if (minute > time.minute)
            return 1;
        if (second < time.second)
            return -1;
        else if (second > time.second)
            return 1;
        return 0;
    }
}
