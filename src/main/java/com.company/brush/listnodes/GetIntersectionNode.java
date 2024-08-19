/**
 * @author: Wxj
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
package com.company.brush.listnodes;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    // 哈希表
    public ListNode solution1(ListNode headA, ListNode headB) {
        // 初始化哈希表，存储链表A的所有结点
        Set<ListNode> nodeSet = new HashSet<>();
        // 遍历链表A，放到nodeSet里
        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        // 遍历链表B，与nodeSet里的节点比较，如果nodeSet里存在遍历到的节点，就是相交的头结点
        while (headB != null) {
            if (nodeSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    // 双指针
    // 假设链表 headA 和 headB 的长度分别是 m 和 n，
    // 链表 headA 的不相交部分有 a 个节点，链表 headB 的不相交部分有 b 个节点，两个链表相交的部分有 c 个节点，
    // 则有 a+c=m，b+c=n。
    // 如果相交，指针a 走了 a+c+b，指针b 走了b+c+a，相等。
    public ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
