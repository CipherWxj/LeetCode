/**
 * @author: Wxj
 * 142. 环形链表 II
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>输入描述:
 * head = [3,2,0,-4], pos = 1
 * <p>输出描述:
 * 返回索引为 1 的链表节点
 */
package com.company.brush.listnodes;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    // 哈希表
    public ListNode solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // 龟兔赛跑（快慢指针）
    public ListNode solution2(ListNode head) {

        // 为了能让 while 执行，将 慢指针 设置为 头节点，快指针 设为 第二个节点！！！
        ListNode slow = head;
        ListNode fast = head;

        // 两个指针没有相遇时一直遍历
        while (true) {
            // 快指针到最后还没有相遇说明没有环
            if (fast == null || fast.next == null) return null;

            // 遍历
            slow = slow.next; // 慢指针一次走一步
            fast = fast.next.next; // 快指针一次走两步

            // 相遇
            if (slow == fast) break;
        }

        // 有环，则找寻入环节点位置
        // 数量关系需要自己推导
        ListNode search = head;

        while (search != slow) {
            search = search.next;
            slow = slow.next;
        }
        return slow;
    }
}
