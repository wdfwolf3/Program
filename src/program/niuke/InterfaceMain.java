package program.niuke;

/**
 * Created by Fung on 2017/7/3.
 */
public interface InterfaceMain {
    //    public void main(String[] args);
    static void main(String[] args) {
        System.out.println("ss");
        int n = -2147483648;
        int count = 0;
        n = n - 1;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        System.out.println(count);
    }

//    static void get();    static 需要实现方法，不能写一句

    static void get() {

    }

//    protected void g();     不允许非public
}
