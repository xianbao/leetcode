package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.baseclass.ListNode;

/**
 * 对连链表按照插插入法排序
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q;
        boolean hasFound;
        while (true) {
            hasFound = false;
            while (p.next != null) {
                // 寻找第一个开始逆序的节点位置
                if (p.next.val < p.val) {
                    hasFound = true;
                    break;
                } else {
                    p = p.next;
                }
            }
            if (hasFound) {
                // p.next需要进行插入排序
                ListNode temp = p.next;
                p.next = temp.next;
                q = head;
                ListNode pre = head;
                while (q.val < temp.val) {
                    pre = q;
                    q = q.next;
                }
                if (q == head) {
                    temp.next = head;
                    head = temp;
                } else {
                    temp.next = pre.next;
                    pre.next = temp;
                }
            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        InsertionSortList test = new InsertionSortList();
        test.insertionSortList(head);
    }

}
