package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.TreeNode;

/**
 * 根据树遍历结果，构造树
 **/
public class TreeCreator {

    /**
     * 根据先序和中序构造树
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildRecursive(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    public static TreeNode buildRecursive(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                treeNode.left = buildRecursive(preorder,pStart + 1, pStart + i - inStart, inorder, inStart, i - 1);
                treeNode.right = buildRecursive(preorder, pStart + i - inStart + 1, pEnd, inorder, i + 1, inEnd);
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);

    }

}
