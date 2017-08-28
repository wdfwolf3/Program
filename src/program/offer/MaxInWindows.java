package program.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Fung on 2017/7/6.
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new MaxInWindows().maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, left = 0;
        for (; i < size; i++)
            queue.offer(num[i]);
        list.add(queue.peek());
        for (; i < num.length; i++) {
            queue.remove(num[left++]);
            queue.offer(num[i]);
            list.add(queue.peek());
        }
        return list;
    }
}
