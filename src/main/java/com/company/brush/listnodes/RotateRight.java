/**
 * @author: Wxj
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>输入描述:
 * head = [1,2,3,4,5], k = 2
 * <p>输出描述:
 * [4,5,1,2,3]
 */
package com.company.brush.listnodes;

public class RotateRight {
    public ListNode solution(ListNode head, int k) {
        // 特殊情况
        if (head == null || head.next == null || k == 0) return head;
        // 找到链表的末尾节点，计算链表长度
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++len;
        }
        // 将末尾节点与头节点链接
        tail.next = head;
        // 找到旋转之后头节点的位置（从右往左数第 k % len 个）
        ListNode newTail = new ListNode(); // 新的尾节点
        newTail.next = head;
        for (int i = 0; i < len - k % len; i++) {
            newTail = newTail.next;
        }
        //
        ListNode newHead = newTail.next; // 新的头节点
        newTail.next = null;

        return newHead;
    }
}
