package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthofBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int count) {
        int temp = count;
        if (root != null)
            temp += 1;
        else return temp;
        count = Math.max(count, dfs(root.left, temp));
        count = Math.max(count, dfs(root.right, temp));
        return count;
    }

    public int lastRemaining(int n, int m) {
        List<Integer> remainingList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            remainingList.add(i);
        }
        int index;
        int current = 0;
        // 0 1 2 3 4
        while (remainingList.size() > 1) {
            if(m + current > remainingList.size()) {
                current = (m + current) % remainingList.size() - 1;
                remainingList.remove(current == - 1 ? 0 : current);
            } else {
                remainingList.remove(m + current - 1);
                current = m + current - 1 ;
                current = current >= remainingList.size() ? current - 1 : current;

            }
        }
        return remainingList.get(0);
    }



    public static void main(String[] args) {
        MaximumDepthofBinaryTree object = new MaximumDepthofBinaryTree();
        System.out.println(object.lastRemaining(10, 17));
    }
}
