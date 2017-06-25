package program.Tree;

/**
 * 随机构建的二叉搜索树期望高度为O(lgn);构建的最坏时间复杂度O(n2)，平均时间复杂度O(nlgn)
 * 中序遍历得到排序数组，时间复杂度O(n)
 *
 * Created by wdfwolf3 on 2017/5/17.
 */
public class BinarySearchTree {
    public BinarySearchTreeNode root;

    public BinarySearchTree(BinarySearchTreeNode root) {
        this.root = root;
    }

    public BinarySearchTreeNode MinimumNode() {
        return MinimumNode(root);
    }

    public BinarySearchTreeNode MaximumNode() {
        return MaximumNode(root);
    }

    public void insert(BinarySearchTreeNode node) {
        if (root == null) root = node;
        BinarySearchTreeNode parent = root;
        BinarySearchTreeNode child = root;
        while (child != null) {
            parent = child;
            if (node.value < child.value) child = child.left;
            else child = child.right;
        }
        node.parent = parent;
        if (node.value < parent.value) parent.left = node;
        else parent.right = node;
    }

    public void delete(BinarySearchTreeNode node) {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            BinarySearchTreeNode successor = node.successor();
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
    public void transplant(BinarySearchTreeNode oldNode, BinarySearchTreeNode newNode) {
        if(oldNode.parent!=null){
            if (oldNode.parent.left == oldNode) oldNode.parent.left = newNode;
            else oldNode.parent.right = newNode;
        }
        if (newNode != null) newNode.parent = oldNode.parent;
    }

    public static BinarySearchTreeNode MinimumNode(BinarySearchTreeNode root) {
        if (root != null) {
            while (root.left != null) root = root.left;
        }
        return root;
    }

    public static BinarySearchTreeNode MaximumNode(BinarySearchTreeNode root) {
        if (root != null) {
            while (root.right != null) root = root.right;
        }
        return root;
    }
}
