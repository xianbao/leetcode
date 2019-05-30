package com.xiao.leetcode.algorithm;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReorderList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return ;
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count += 1;
            p = p.next;
        }
        count = count % 2 == 0 ? count / 2 : count / 2 + 1;
        // count 开始对链表逆序
        p = head;
        while (count > 1) {
            p = p.next;
            count -= 1;
        }
        ListNode q = p.next;
        // q节点开始翻转
        ListNode n = q, node = q;
        ListNode temp;
        while (q != null) {
            temp = q.next;
            q.next = n;
            n = q;
            q = temp;
        }
        node.next = null;
        p.next = null;
        p = head;
        while (p != null && n != null) {
            temp = p.next;
            node = n.next;
            n.next = p.next;
            p.next = n;
            n = node;
            p = temp;
        }
    }

    public static void main(String[] args) {
        ReorderList test = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        test.reorderList(head);
    }

}
