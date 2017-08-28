package program.offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.peekLast();
            while (node.left != null) {
                queue.offer(node.left);
                node = queue.peekLast();
                sum += node.val;
            }
            if (queue.peekLast().right == null) {
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (TreeNode node1 : queue)
                        list.add(node1.val);
                    ans.add(list);
                }
                node = queue.pollLast();
                sum -= node.val;
                while (!queue.isEmpty() && (queue.peekLast().right == null || node == queue.peekLast().right)) {
                    node = queue.pollLast();
                    sum -= node.val;
                }
                if (!queue.isEmpty()) {
                    queue.offer(queue.peekLast().right);
                    sum += queue.peekLast().val;
                }
            } else {
                queue.offer(queue.peekLast().right);
                sum += queue.peekLast().val;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = node;
        root.right = new TreeNode(4);
        FindPath findPath = new FindPath();
        System.out.println(findPath.findPath(root, 6));
    }
}
