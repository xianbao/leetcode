package com.xiao.leetcode.algorithm;

/**Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 .*/
public class PartitionList {
    public RotateList.ListNode partition(RotateList.ListNode head, int x) {
        if (head == null || head.next == null) return head;
        RotateList.ListNode p;
        // 头节点值就大于x
        RotateList.ListNode temp, tail;
        if (head.val >= x) {
            p = head;
            RotateList.ListNode node = new RotateList.ListNode(0);
            tail = node;
            RotateList.ListNode q = p.next;
            while (q != null) {
                if (q.val < x) {
                    temp = q;
                    p.next = q.next;
                    q = q.next;
                    tail.next = temp;
                    tail = temp;
                    temp.next = null;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
            tail.next = head;
            return node.next;
        } else {
            tail = head;
            p = head;
            int count = 0;
            RotateList.ListNode q = null;
            RotateList.ListNode node = p.next;
            while (node != null) {
                if (node.val >= x && count == 0) {
                    count += 1;
                    q = node;
                    node = node.next;
                    p = p.next;
                } else if (node.val < x && count > 0) {
                    temp = node;
                    p.next = node.next;
                    node = node.next;
                    tail.next = temp;
                    tail = temp;
                    temp.next = q;
                } else if (node.val >= x){
                    node = node.next;
                    p = p.next;
                } else {
                    tail = tail.next;
                    node = node.next;
                    p = p.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        RotateList.ListNode head = new RotateList.ListNode(3);
        head.next = new RotateList.ListNode(1);
        head.next.next = new RotateList.ListNode(2);

        test.partition(head, 3);
    }

}
