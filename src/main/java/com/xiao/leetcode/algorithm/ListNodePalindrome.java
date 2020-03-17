package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.ListNode;

/**
 * @Auther: xxb
 * @Date: 2020/1/16 10:57
 * @Description: 验证链表是否是回文链表,
 * 查找到链表中点，将链表的后半部分进行反转，以此能够达到o(n)时间的复杂度，o(1)空间复杂度
 */
public class ListNodePalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 查找到中间节点
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count += 1;
        }

        int middle = (count - 1) / 2;
        count = 0;
        p = head;
        while (count != middle) {
            p = p.next;
            count += 1;
        }
        // 开始反转后半部分链表
        ListNode q = p.next;
        ListNode tmp = q, pre = null;
        while (q != null) {
            tmp = q.next;
            q.next = pre;
            pre = q;
            if (tmp == null)
                break;
            q = tmp;
        }

        p = head;
        while (q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
