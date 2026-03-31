package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>输入描述:
 * head = [1,2,6,3,4,5]
 * <p>输出描述:
 * [5，4，3，2，1]
 */
public class ReverseList {
    public static ListNode reverseListWithWhile(ListNode head) {
        // 上一个节点
        ListNode lastNode = null;
        while (head != null) {
            // 指针指向当前节点，用于反转操作
            ListNode temp = head;
            // 右移遍历
            head = head.next;
            // 反转
            temp.next = lastNode;
            // 更新上一个节点
            lastNode = temp;
        }
        return lastNode;
    }

    public static ListNode reverseListWithRecursion(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归调用，假设深入到最后一个节点head.next（此时实际head指向倒数第二个节点），命中终止条件返回，用temp指针指向最后一个节点
        ListNode temp = reverseListWithRecursion(head.next);
        // 反转操作
        head.next.next = head;
        // 断开原指针
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //ListNode res = reverseListWithWhile(head);
        ListNode res = reverseListWithRecursion(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
