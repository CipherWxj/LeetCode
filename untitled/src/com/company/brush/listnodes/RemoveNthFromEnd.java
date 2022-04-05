/**
 * @author: Wxj
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 假设链表节点总数大于等于 n。
 * <p>输入描述:
 * head = [1,2,3,4,5], n = 2
 * <p>输出描述:
 * [1,2,3,5]
 */
package com.company.brush.listnodes;

public class RemoveNthFromEnd {
    public ListNode solution(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 快慢指针，用于找到待删除节点的位置，这才是本题的重点
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先让 fast 跑 n步
        // 则剩余节点数为 Len - n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 再同时走，直到 fast 到最末尾节点
        // 此时 slow 也走了 Len - n 步，slow.next 即为倒数第 n 个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除 slow.next
        slow.next = slow.next.next;
        // 这里返回不返回 head，是因为 head 也可能被删除
        return dummy.next;
    }
}
