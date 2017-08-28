package program.javaTest.threadtest;

/**
 * Created by wdfwolf3 on 2017/5/5.
 */
public class PrintABC implements Runnable {
    String name;
    Object pre;
    Object self;

    public PrintABC(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrintABC pa = new PrintABC("A", c, a);
        PrintABC pb = new PrintABC("B", a, b);
        PrintABC pc = new PrintABC("C", b, c);

        Thread ta = new Thread(pa);
        Thread tb = new Thread(pb);
        Thread tc = new Thread(pc);

        try {
            ta.start();
            Thread.sleep(3000);
            tb.start();
            Thread.sleep(3000);
            tc.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            synchronized (pre) {
                synchronized (self) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name);
                    self.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
