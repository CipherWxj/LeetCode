/**
 * @author: Wxj
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>输入描述:
 * l1 = [7,2,4,3]
 * l2 = [5,6,4]
 * <p>输出描述:
 * [7,8,0,7]
 */
package com.company.brush.listnodes;

import java.util.*;

public class AddTwoNumbers {
    // 题目说不能反转，用栈模拟反转
    public static ListNode solution(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();
        // 所有节点入栈
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0; // 进位
        ListNode cur = null; // 当前节点
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop().val;
            int y = stack2.isEmpty() ? 0 : stack2.pop().val;
            ListNode next = cur; // 暂存当前节点
            cur = new ListNode((x + y + carry) % 10); // 更新当前节点
            cur.next = next; // 连接
            carry = (x + y + carry) / 10; // 更新进位
        }
        // 最后判断进位
        if (carry > 0) {
            ListNode next = cur;
            cur = new ListNode(carry);
            cur.next = next;
        }
        return cur;
    }
}
