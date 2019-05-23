package algorithm;

import java.util.ArrayList;
import java.util.List;

/**Given a binary tree, flatten it to a linked list in-place.*/
public class FlattenBinary {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        preTraverse(list, root);
        TreeNode node = root;
        for (int i = 0; i < list.size(); i++) {
            node.left = null;
            node.val = list.get(i);
            if (node.right == null && i + 1 < list.size()) {
                node.right = new TreeNode(0);
                node = node.right;
            } else {
                node = node.right;
            }
        }
    }

    public void preTraverse(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preTraverse(list, root.left);
        preTraverse(list, root.right);
    }

    public static void main(String[] agrs) {
        FlattenBinary test = new FlattenBinary();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);
        test.flatten(root);
    }

}
