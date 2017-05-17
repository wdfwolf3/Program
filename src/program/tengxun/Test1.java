package program.tengxun;

/**
 * Created by wdfwolf3 on 2017/4/3.
 */
public class Test1{
    public static void main(String[] args) {
        String str="abcdefghhijklmnopqrstuvwxyzabcdefghij";
        for (int i = 0; i < str.length(); i=i+16) {
            System.out.printf("%08x  ", i);
            int j=i;
            for (;j<16+i;j++){
                int n = str.charAt(j);
                System.out.printf("%x  ", n);
            } System.out.println(str.substring(i,j));
        }
    }
}
