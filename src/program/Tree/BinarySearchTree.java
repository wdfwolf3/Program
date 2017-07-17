package program.Tree;

/**
 * 随机构建的二叉搜索树期望高度为O(lgn);构建的最坏时间复杂度O(n2)，平均时间复杂度O(nlgn)
 * 中序遍历得到排序数组，时间复杂度O(n)
 * <p>
 * Created by wdfwolf3 on 2017/5/17.
 */
public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode MinimumNode() {
        return MinimumNode(root);
    }

    public TreeNode MaximumNode() {
        return MaximumNode(root);
    }

    public void insert(TreeNode node) {
        if (root == null) root = node;
        TreeNode parent = root;
        TreeNode child = root;
        while (child != null) {
            parent = child;
            if (node.value < child.value) child = child.left;
            else child = child.right;
        }
        node.parent = parent;
        if (node.value < parent.value) parent.left = node;
        else parent.right = node;
    }

    public void delete(TreeNode node) {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            TreeNode successor = node.getSuccessor();
            if (node.right != successor) {
                transplant(successor, successor.right);
                successor.right = node.right;
            }
            successor.left = node.left;
            transplant(node, successor);
        }
    }

    /*
        oldNode != null;否则找不到其父节点
        注意判断是否根节点
     */
    public void transplant(TreeNode oldNode, TreeNode newNode) {
        if (oldNode.parent != null) {
            if (oldNode.parent.left == oldNode) oldNode.parent.left = newNode;
            else oldNode.parent.right = newNode;
        }
        if (newNode != null) newNode.parent = oldNode.parent;
    }

    public static TreeNode MinimumNode(TreeNode root) {
        if (root != null)
            while (root.left != null) root = root.left;
        return root;
    }

    public static TreeNode MaximumNode(TreeNode root) {
        if (root != null)
            while (root.right != null) root = root.right;
        return root;
    }
}
