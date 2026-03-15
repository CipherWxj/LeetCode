/**
 * @author: Wxj
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>输入描述:
 * head = [3,2,0,-4], pos = 1
 * <p>输出描述:
 * true
 */
package com.company.brush.listnodes;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    // 哈希表
    public boolean solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // 龟兔赛跑（快慢指针）
    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) return false;

        // 为了能让 while 执行，将 慢指针 设置为 头节点，快指针 设为 第二个节点！！！
        ListNode slow = head;
        ListNode fast = head.next;

        // 两个指针没有相遇时一直遍历
        while (slow != fast) {
            // 快指针到最后还没有相遇说明没有环
            if (fast == null || fast.next == null) return false;

            // 遍历
            slow = slow.next; // 慢指针一次走一步
            fast = fast.next.next; // 快指针一次走两步
        }
        // 相遇
        return true;
    }
}
