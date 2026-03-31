package com.company.brush.listNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wangxinjian
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>输入描述:
 * intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * <p>输出描述:
 * Intersected at '8'
 */
public class GetIntersectionNode {
    private static ListNode getIntersectionNodeWithHash(ListNode headA, ListNode headB) {
        // 初始化哈希Set，存储链表A的
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // 遍历链表B，如果B的节点在A中存在，则相交
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 指针a遍历完链表A接着遍历链表B
        // 指针b遍历完链表B接着遍历链表A
        // 每次遍历一位，如果相交一定相遇，否则不相交遍历完一定为null
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode intersectNode = new ListNode(8);
        intersectNode.next = new ListNode(4);
        intersectNode.next.next = new ListNode(5);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectNode;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectNode;
        ListNode res1 = getIntersectionNodeWithHash(headA, headB);
        System.out.println(res1 == null ? "null" : res1.val);
        ListNode res2 = getIntersectionNode(headA, headB);
        System.out.println(res2 == null ? "null" : res2.val);
    }
}
