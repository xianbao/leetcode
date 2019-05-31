package com.xiao.leetcode.algorithm;

/**
 * 判断链表是否包含环
 */
public class LinkedListCycle {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode low = head;
        ListNode fast = head.next.next;
        while (fast != null) {
            if (low == fast) {
                return true;
            }
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
            low = low.next;
        }

        return false;
    }
}
