package com.xiao.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        queue1.add(root.left);
        queue2.add(root.right);
        boolean result = true;
        while (true) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 != null && node2 != null && node1.val == node2.val) {
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
            } else if (node1 != null || node2 != null){
                result = false;
                break;
            }
            if (queue1.size() == 0 || queue2.size() == 0) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SymmetricTree test = new SymmetricTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(test.isSymmetric(node));
    }
}
