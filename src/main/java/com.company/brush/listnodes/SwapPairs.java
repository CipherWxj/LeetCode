/**
 * @author: Wxj
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>输入描述:
 * nums = [1,2,3,4]
 * <p>输出描述:
 * [2,1,4,3]
 */
package com.company.brush.listnodes;

public class SwapPairs {
    // 迭代
    public ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 表示上一段的最后一个节点，方便连接
        ListNode pre = dummy;
        // 遍历，剩下的节点还剩余两个及以上才交换
        while (pre.next != null && pre.next.next != null) {
            // 第一个
            ListNode first = pre.next;
            // 第二个
            ListNode second = pre.next.next;
            // 交换位置
            first.next = second.next;
            second.next = first;
            // 与之前已经交换的连接
            pre.next = second;
            // 遍历更新
            pre = first;
        }
        return dummy.next;
    }

    // 递归
    public ListNode solution2(ListNode head) {
        // 终止条件
        if(head == null || head.next == null) return head;
        // 记录第二个节点
        ListNode temp = head.next;
        // 交换，指向下一段，并递归
        head.next = solution2(temp.next);
        temp.next = head;
        // 返回原始链表的第二个节点（交换后成第一个了）
        return temp;
    }
}
