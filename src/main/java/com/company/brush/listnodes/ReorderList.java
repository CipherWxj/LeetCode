/**
 * @author: Wxj
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>输入描述:
 * head = [1,2,3,4]
 * <p>输出描述:
 * [1,4,2,3]
 */
package com.company.brush.listnodes;

public class ReorderList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = midNode(head);  // 分段，找到中间节点
        ListNode head2 = reverse(midNode.next); // 后半段反转
        midNode.next = null; // 截取前半段
        return merge(head, head2); // 合并
    }

    // 找中间节点
    // 快慢指针，如果总共是奇数个节点，找到最中间那个；总数是偶数个，找到第n/2个
    public ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 终止条件的设定决定找到的节点是哪一个
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 反转
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    // 合并
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        dummy.next = l1;
        ListNode cur = l1;
        while (l1 != null && l2 != null) {
            // l1 和 l2 交替链接
            if (cur == l1) {
                l1 = l1.next;
                cur.next = l2;
            }
            if (cur == l2) {
                l2 = l2.next;
                cur.next = l1;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
