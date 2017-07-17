package program.Tree;

/**
 * 从树最小节点开始寻找后续构建有序队列时间复杂度O(N).
 * 我们根据算法可以知道，每条边被遍历2次，一次向上，一次向下。因为共n-1条边，则共访问2(n-1)次，即O(n)。
 * <p>
 * 从任意结点使用后继函数k次，假设二叉搜索树的高度为h，则时间复杂度为O(k+h).
 * 设定遍历的起始结点为S，结束结点为T，则S和T的关系总共有3种
 * (1) S 和 T有共同的祖先结点p，S在P的左子树，T在P的右子树
 * 左子树中所有在Ls右方的所有结点都会作为后继被遍历到,仅仅访问Ls右方、Lt左方的结点.
 * k = s + t + 1; 左：s + (h-1);右：t + (h-1)
 * T = 2s + (h-1) + 2*t + (h-1) + 2 =2*k + 2(h-1) = O(k+n);
 * (2) T 为S的祖先，S在T的左子树中,同理可证
 * (3) S 为T的祖先，T在S的右子树中，同理可证
 * <p>
 * Created by wdfwolf3 on 2017/5/17.
 */
public class BinarySearchTreeNode extends TreeNode {
    /*
    如果右孩子非空，后继为右子树中最小结点。否则向上寻找到第一个在左子树的节点。
     */
    public TreeNode getSuccessor() {
        if (right == null) {
            TreeNode tmpParent = parent;
            TreeNode tmpChild = this;
            while (tmpParent != null && tmpParent.right == tmpChild) {
                tmpChild = tmpParent;
                tmpParent = tmpParent.parent;
            }
            return tmpChild;
        }
        return BinarySearchTree.MinimumNode(right);
    }

    public TreeNode getPredecessor() {
        if (left == null) {
            TreeNode tmpParent = parent;
            TreeNode tmpChild = this;
            while (tmpParent != null && tmpParent.left == tmpChild) {
                tmpChild = tmpParent;
                tmpParent = tmpParent.parent;
            }
            return tmpChild;
        }
        return BinarySearchTree.MaximumNode(left);
    }
}
