package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.ListNode;

/**
 * 对链表排序,时间复杂度是O(nlogn)，空间复杂度是常量,
 * 相当于对链表进行快速排序
 */
public class SortList {
    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        quickSort(head, null);
        return head;
    }

    private ListNode quickPartition(ListNode start, ListNode end) {
        // 以start为基准点
        int pivot = start.val;
        ListNode right = start.next;
        ListNode left = start;
        while (right != end) {
            if (right.val < pivot) {
                left.val = right.val;
                left = left.next;
                right.val = left.val;
            }
            right = right.next;
        }
        left.val = pivot;
        return left;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start == end || start.next == end)
            return;
        ListNode node = quickPartition(start, end);
        quickSort(start, node);
        quickSort(node.next, end);
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        test.sortList(head);
    }


}
