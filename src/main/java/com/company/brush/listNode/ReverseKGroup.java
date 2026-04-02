package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 25. K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>输入描述:
 * head = [1,2,3,4,5], k = 2
 * <p>输出描述:
 * [2,1,4,3,5]
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        // 虚拟头节点
        dummy.next = head;
        // 前驱节点
        ListNode prev = dummy;
        // 用head做遍历节点
        while (head != null) {
            // 按k个节点分组，head是每组的第一个节点，tail是每组的最后一个节点
            ListNode tail = head;
            for (int i = 1; i < k; i++) {
                // 如果剩余节点不足k个，则不进行翻转
                if (tail.next == null) return dummy.next;
                tail = tail.next;
            }
            // 断开tail，便于反转操作，记录下一组的头节点
            ListNode nextHead = tail.next;
            tail.next = null;
            // 反转，并连接反转后的链表
            prev.next = reverse(head);
            // 反转后的链表连接下一组待反转的节点
            head.next = nextHead;
            // 右移
            prev = head;
            head = nextHead;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
