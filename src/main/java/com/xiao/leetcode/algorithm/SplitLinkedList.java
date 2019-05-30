package com.xiao.leetcode.algorithm;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list
 * into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size
 * differing by more than 1. This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list, and parts occurring earlier
 * should always have a size greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
public class SplitLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null)
            return result;
        int count = 0;
        ListNode node = root;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        int remainder = count % k;
        count /= k;
        node = root;
        int temp = count;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int index = 0;
        while (node != null) {
            // k大于链表总长度，依次填充一个元素
            if (count == 0) {
                result[index++] = new ListNode(node.val);
            } else if (temp > 0) {
                p.next = new ListNode(node.val);
                p = p.next;
                temp -= 1;
            } else if (remainder >= 0) {
                if (remainder > 0) {
                    p.next = new ListNode(node.val);
                    remainder -= 1;
                    node = node.next;
                }
                result[index++] = head.next;
                if (node == null)
                    break;
                head = new ListNode(0);
                p = head;
                p.next = new ListNode(node.val);
                p = p.next;
                temp = count - 1;
            }
            node = node.next;
        }
        if (head.next != null) {
            result[index] = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        SplitLinkedList test = new SplitLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        test.splitListToParts(head, 3);
    }
}
