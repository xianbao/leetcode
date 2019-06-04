package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.ListNode;

/**
 * 删除链表里指定值的节点.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node, temp;
        while (p.next != null) {
            if (p.next.val == val) {
                temp = p.next;
                p.next = temp.next;
            } else {
                p = p.next;
            }
        }
        return node.next;
    }
}
