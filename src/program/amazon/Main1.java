package program.amazon;

public class Main1 {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node node = root;
        for (int i = 1; i < 5; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        node.next = root;
        node = root;
    }
}

class Node{
    public Node next;
    public int val;

    public Node(int val) {
        this.val = val;
    }
}
