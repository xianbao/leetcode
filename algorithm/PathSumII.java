package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode node, int sum,
                    List<List<Integer>> result, List<Integer> temp) {
        if (node == null) return;
        else if (node.left == null && node.right == null) {
            if (sum - node.val == 0) {
                temp.add(node.val);
                List<Integer> list = new ArrayList<>(temp);
                result.add(list);
                temp.remove(temp.size() - 1);
            }
            return;
        }
        sum -= node.val;
        temp.add(node.val);
        dfs(node.left, sum, result, temp);
        dfs(node.right, sum, result, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII test = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        test.pathSum(root, 22);
    }

}
