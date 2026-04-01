package com.company.brush.listNode;

import static com.company.brush.listNode.ReverseList.reverseListWithWhile;

/**
 * @author: wangxinjian
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>输入描述:
 * head = [1,2,2,1]
 * <p>输出描述:
 * true
 */
public class IsPalindrome {
    private static boolean isPalindrome(ListNode head) {
        // 找到链表的中间节点
        ListNode half = findHalfNode(head);
        ListNode l1 = head;
        // 反转后半部分链表
        ListNode l2 = reverseListWithWhile(half);
        // 遍历比较
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    // 快慢指针找到中间节点
    // 对于奇数个节点，slow 指向中间节点
    // 对于偶数个节点，slow 指向中间两个节点的第二个
    public static ListNode findHalfNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
