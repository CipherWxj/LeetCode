package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 2. 两数相加
 * 给你两个非空的 链表 ，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字；
 * 请你将两个数 相加 ，并以相同形式返回一个表示 和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 * <p>输入描述:
 * l1 = [2,4,3]
 * l2 = [5,6,4]
 * <p>输出描述:
 * [7,0,8]
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 创建虚拟头节点
        ListNode dummy = new ListNode();
        // 当前节点
        ListNode cur = dummy;
        // 进位
        int carry = 0;
        // 遍历两个链表
        while (l1 != null || l2 != null) {
            // 获取两个链表当前节点的值，如果为空则为0
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            // 计算当前节点的值和进位
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            // 创建新节点并连接到当前节点
            cur.next = new ListNode(sum);
            // 移动到下一个节点
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 处理最终的进位
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
