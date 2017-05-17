package program.sort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wdfwolf3 on 2017/2/15.
 */
public class Test1 {
    public static void main(String[] args) {
//        try{
//            Socket socket = new Socket("localhost", 8080);
//            InputStream inputStream = socket.getInputStream();
//        }catch (IOException e){
//            System.out.println(e + "dd");
//            e.printStackTrace();
//        }
//         try{
//             TestException testException = new TestException("aaa");
//             throw testException;
//         }catch (Exception e){
//             System.out.println(e.getMessage());
//             System.out.println("wdf");
//             e.printStackTrace();
//         }
//
        String string1 = "sdkfl";
        String[] strings = string1.split("d");
        for(String string:strings){
            System.out.println(string);
        }

        Pattern pattern = Pattern.compile(" ");
        System.out.println(pattern.pattern());
        String[] strings1 = pattern.split("input String");

        Matcher matcher = pattern.matcher("input Stirng");
        System.out.println(matcher.matches());
        System.out.println(matcher.find());
        System.out.println(matcher.lookingAt());

        Pattern pattern1 = Pattern.compile("\\d+");
        Matcher matcher1 = pattern1.matcher("aa2233bb22");
        matcher1.find();
        System.out.println(matcher1.end());
        System.out.println(matcher1.start());
        System.out.println(matcher1.group());
        matcher1.find();
        System.out.println(matcher1.end());
        System.out.println(matcher1.start());
        System.out.println(matcher1.group());

        System.out.println(Pattern.matches("//d+", "22aa33"));

        Pattern pattern2 = Pattern.compile("((wdf)(\\w))");
        String input = "wdfawdfawdfa";
        Matcher matcher2 = pattern2.matcher(input);
        System.out.println(matcher2.groupCount());
        matcher2.find();
        for (int i = 0; i < 4; i++) {
            System.out.println(matcher2.group(i));
        }
        System.out.println(matcher2.replaceAll("b"));
        System.out.println(matcher2.replaceFirst("c"));
    }
}
