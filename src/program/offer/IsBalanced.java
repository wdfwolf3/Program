package program.offer;

import java.util.HashMap;
import java.util.Map;

public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        return help(root, map);
    }

    public boolean help(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null)
            return true;
        if (!help(node.left, map) || !help(node.right, map))
            return false;
        if (Math.abs(map.get(node.left) - map.get(node.right)) > 1)
            return false;
        map.put(node, Math.max(map.get(node.left), map.get(node.right)));
        return true;
    }
}
