package program.javaTest;

import java.util.Base64;

public interface InterfaceTest {
    int n = 0;


    static void main(String[] args) {
        System.out.println("abc");
        print();
    }

    static void print() {
        String s = "12ksadjlkfjsaldf";
        s = Base64.getEncoder().encodeToString(s.getBytes());
        System.out.println(s);
        s = new String(Base64.getDecoder().decode(s));
        System.out.println(s);
    }

}
