package program.javaTest.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/nio.txt"));
                String s = null;
                List<String> list = new ArrayList<>();
                while ((s=bufferedReader.readLine())!=null){
                    list.add(s);
                }
                for (String name : list){
                    Class c = Class.forName(name);
                    System.out.println(c.getName());
                    Object object = c.newInstance();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            int i = scanner.nextInt();
        }
    }
}
