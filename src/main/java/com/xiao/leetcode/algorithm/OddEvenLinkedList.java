package com.xiao.leetcode.algorithm;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 移动奇数位置的节点至一起
 * */
public class OddEvenLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        boolean isOdd = true;
        ListNode pre = head;
        ListNode node = pre.next.next;
        // tail保存最后一个偶数位置节点
        ListNode tail = pre.next, q;
        while (node != null) {
            if (isOdd) {
                q = node.next;
                node.next = pre.next;
                pre.next = node;
                tail.next = q;
                tail = q;
                isOdd = false;
                pre = node;
                node = q;
            } else {
                isOdd = true;
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList test = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        test.oddEvenList(head);
    }

}
