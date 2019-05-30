package com.xiao.leetcode.algorithm;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 遍历二叉树
 */
public class BinaryTreeZigzag {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        //0-右至左；1-左至右
        int direction = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (stack.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (direction == 0) {
                        tempStack.add(node.right);
                        tempStack.add(node.left);
                    } else {
                        tempStack.add(node.left);
                        tempStack.add(node.right);
                    }
                    temp.add(node.val);
                }
            }
            if (temp.size() > 0)
                result.add(temp);
            if (direction == 0) direction = 1;
            else direction = 0;
            stack.addAll(tempStack);
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTreeZigzag test = new BinaryTreeZigzag();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        test.zigzagLevelOrder(root);

    }
}
