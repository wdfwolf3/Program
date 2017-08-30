package program.javaTest;

/**
 * Created by wdfwolf3 on 2017/8/23.
 */
public class StringTest {
    public static void main(String[] args) throws InterruptedException {
        String greet = "😥hello!";
        System.out.println(greet.length());
        int cp = greet.codePointCount(0, 8);
        System.out.println(greet.codePointAt(0));
        System.out.println(greet.codePointAt(1));
        System.out.println(greet.codePointAt(2));
        System.out.println(Character.isSupplementaryCodePoint(greet.codePointAt(2)));
        for (int i = 0; i < greet.length(); i++) {
            if (Character.isSupplementaryCodePoint(greet.codePointAt(i))) {
                System.out.println(greet.substring(i, i + 2));
                i++;
            } else
                System.out.println(greet.charAt(i));
        }
        System.out.println(Character.isSurrogate(greet.charAt(0)));
        System.out.println(Character.isSurrogate(greet.charAt(1)));
        System.out.println(Character.isSurrogate(greet.charAt(2)));
        System.out.println(greet.charAt(2));

        StringBuilder builder = new StringBuilder();
        Thread thread1 = new Thread(new BuilderAppend(builder));
        Thread thread2 = new Thread(new BuilderAppend(builder));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(builder.length());

        StringBuffer buffer = new StringBuffer();
        thread1 = new Thread(new BufferAppend(buffer));
        thread2 = new Thread(new BufferAppend(buffer));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(buffer.length());
    }
}

class BufferAppend implements Runnable {
    private StringBuffer buffer;

    public BufferAppend(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public BufferAppend() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            buffer.append("a");
        }
    }
}

class BuilderAppend implements Runnable {
    private StringBuilder builder;

    public BuilderAppend(StringBuilder builder) {
        this.builder = builder;
    }

    public BuilderAppend() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            builder.append("a");
        }
    }
}
