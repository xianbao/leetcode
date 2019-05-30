package com.xiao.leetcode.algorithm;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 删除重复元素
 */
public class RemoveDuplicatesListII {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode newNode = new ListNode(0);
        ListNode tail = head;
        ListNode pre = newNode;
        pre.next = tail;
        int currentValue = head.val;
        int count = 1;
        while (p != null) {
            if (currentValue == p.val) count += 1;
            if (currentValue != p.val) {
                if (tail.val == currentValue && count > 1) {
                    tail = p;
                    pre.next = tail;
                    count = 1;
                } else {
                    pre = tail;
                    tail = p;
                    pre.next = tail;
                }
                currentValue = p.val;
            }
            p = p.next;
        }
        if (count > 1) pre.next = null;
        return newNode.next;
    }


    public static void main(String[] args) {
        RemoveDuplicatesListII test = new RemoveDuplicatesListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        test.deleteDuplicates(head);
    }
}
