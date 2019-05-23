package algorithm;

public class PathSum {
    public boolean hasPathSum(MaximumDepthofBinaryTree.TreeNode root, int sum) {
        return false;
    }

    public boolean dfsSum(MaximumDepthofBinaryTree.TreeNode node, int sum, boolean isLeaf) {
        if (node == null) {
            if (sum == 0 && isLeaf)
                return true;
            else
                return false;
        }
        sum -= node.val;
        isLeaf = node.left == null && node.right == null;
        if (dfsSum(node.left, sum, isLeaf)) return true;
        if (dfsSum(node.right, sum, isLeaf)) return true;
        return false;
    }
}
