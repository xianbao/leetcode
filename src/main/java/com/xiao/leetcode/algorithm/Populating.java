package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.ListNode;
import com.xiao.leetcode.util.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 */
public class Populating {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int count = 1;
        // 层数
        int layers = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (count == (int) Math.pow(2, layers)) {
                node.next = null;
                count = 0;
                layers += 1;
            } else {
                node.next = queue.peek();
            }
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            count += 1;
        }
        return root;
    }

    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int count = 0;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                nextCount += 1;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextCount += 1;
            }
            if (count == 0 || count == 1) {
                node.next = null;
                count = nextCount;
                nextCount = 0;
            } else {
                node.next = queue.peek();
                count -= 1;
            }
        }
        return root;
    }
}
