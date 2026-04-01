package com.company.brush.listNode;

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
public class SwapPairs {
    public static ListNode swapPairsWithIteration(ListNode head) {
        if (head == null || head.next == null) return head;
        // 虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // last指向已经交换好的最后一个节点
        ListNode last = dummy;
        // first指向待交换的两个节点中的第一个
        ListNode first = head;
        while (first != null && first.next != null) {
            // next指向待交换的两个节点中的第二个
            ListNode next = first.next;
            // 交换两个节点
            first.next = next.next;
            next.next = first;
            last.next = next;
            // 更新last和first，右移执行下一组
            last = first;
            first = first.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairsWithRecursion(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 待交换的两个节点中的第二个
        ListNode temp = head.next;
        // 递归调用，交换下一组节点，当前待交换的两个节点中的第一个指向下一组调用返回后的节点
        head.next  = swapPairsWithRecursion(head.next.next);
        // 第二个指向第一个
        temp.next = head;
        // 交换后返回第二个
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = swapPairsWithRecursion(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
