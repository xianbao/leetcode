package com.xiao.leetcode.algorithm;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        // 计算链表长度
        int length = 1;
        // p 为尾节点
        ListNode p = head;
        while (p.next != null) {
            length++;
            p = p.next;
        }
        k = k % length;
        if (k == 0) return head;
        ListNode tail = head;
        for (int i = 1; i < length - k; i++) {
            tail = tail.next;
        }
        p.next = head;
        ListNode node = tail.next;
        tail.next = null;
        return node;
    }

    public static void main(String[] args) {
        RotateList test = new RotateList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        test.rotateRight(head, 2);
    }
}
