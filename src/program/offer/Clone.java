package program.offer;

public class Clone {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null)
            return pHead;
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = pHead;
        RandomListNode pre = new RandomListNode(0), q = pre;
        while (p != null) {
            if (p.random == null)
                p.next.random = null;
            else
                p.next.random = p.random.next;
            pre.next = p.next;
            pre = pre.next;
            p = p.next.next;
        }
        return q.next;
    }

    public static void main(String[] args) {
        RandomListNode one = new RandomListNode(0);
        RandomListNode two = new RandomListNode(1);
        RandomListNode three = new RandomListNode(2);
        one.next = two;
        one.random = three;
        two.next = three;
        three.random = one;
        Clone clone = new Clone();
        System.out.println(clone.clone(one));
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
