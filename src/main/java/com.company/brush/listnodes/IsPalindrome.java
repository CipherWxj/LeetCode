/**
 * @author: Wxj
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>输入描述:
 * head = [1,2,2,1]
 * <p>输出描述:
 * true
 */
package com.company.brush.listnodes;

public class IsPalindrome {
    public boolean solution(ListNode head) {
        // 切分链表
        // 分割成两条链表比较，奇偶可以忽略不考虑
        // 奇数个节点中间节点必然相等
        ListNode half = findHalfNode(head);
        ListNode l1 = head;
        ListNode l2 = reverseList(half);
        while(l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    // 找到链表的中点进行分割，返回后半部分
    // 找到第 n/2 + 1 个节点，例如7（4），6（4）
    public ListNode findHalfNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 反转链表
    public ListNode reverseList(ListNode head){
        ListNode last = null;
        while(head != null){
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }
}
