package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.TreeNode;

import java.util.*;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历二叉树
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursivePreorder(root, result);
        return result;
    }

    /**
     * 递归版遍历二叉树
     */
    public static void recursivePreorder(TreeNode treeNode, List<Integer> result) {
        if (treeNode != null) {
            result.add(treeNode.value);
            recursivePreorder(treeNode.left, result);
            recursivePreorder(treeNode.right, result);
        }
    }

    /**
     * 非递归版遍历二叉树
     */
    public static List<Integer> iterativePreorder(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (treeNode != null) {
            stack.push(treeNode);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return result;
    }

    /**
     * 中序遍历二叉树
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveInorder(root, result);
        return result;
    }

    // 中序
    public static void recursiveInorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursiveInorder(root.left, result);
            result.add(root.value);
            recursiveInorder(root.right, result);
        }
    }

    // 后序递归
    public static void recursivePostorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursivePostorder(root.left, result);
            recursivePostorder(root.right, result);
            result.add(root.value);
        }
    }

    // 后序非递归
    public static List<Integer> iterativePostorder(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        TreeNode preNode = null;
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (preNode != null && (node.left == preNode || node.right == preNode)) {
                stack.pop();
                result.add(node.value);
                preNode = node;
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.left == null && node.right == null) {
                stack.pop();
                result.add(node.value);
                preNode = node;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        iterativePostorder(treeNode);
    }
}
