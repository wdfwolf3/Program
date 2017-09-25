package program.javaTest.jvm;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleGc {
    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<int[]>();
        while (true) {
            int[] tmp=new A().execute();
            if (queue.size() > 1000) {
                queue.poll();
            } else {
                queue.offer(tmp);
            }
        }
    }
}

class A {
    int[] storage = new int[102400];
    int[] extra = new int[200000];

    public int[] execute() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return storage;
    }
}