package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 假设链表节点总数大于等于 n。
 * <p>输入描述:
 * head = [1,2,3,4,5], n = 2
 * <p>输出描述:
 * [1,2,3,5]
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 快指针先跑n步
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 慢指针从头开始，快慢指针同时走，二者的距离为n，直到快指针到达链表末尾
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 要删除的节点就是 slow.next
        ListNode needRemove = slow.next;
        // 删除操作
        slow.next = needRemove.next;
        needRemove.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
