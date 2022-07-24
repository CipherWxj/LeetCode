/**
 * @author: Wxj
 * 补充：奇升偶降排序链表
 * 给你一个链表，重新排列节点，排列规则：
 * 奇数位置按序增长，偶数位置按序递减。
 * <p>输入描述:
 * 1->8->3->6->5->4->7->2->NULL
 * <p>输出描述:
 * 1->2->3->4->5->6->7->8->NULL
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddAscEvenDesc {
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddHead = new ListNode(); // 奇序链表
        ListNode evenHead = new ListNode(); // 偶序链表

        // 拆分链表
        ListNode cur = head;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while (cur != null && cur.next != null) {
            odd.next = cur;
            odd = odd.next;
            even.next = cur.next;
            even = even.next;
            cur = cur.next.next;
        }
        // 如果总的节点数是 奇数，最后一个奇序节点为 cur（终止条件：cur.next == null）
        // 如果总的节点数是 偶数，最后一个奇序节点后面还有一个偶序节点，需要断开（cur == null）
        odd.next = cur;
        // 最后一个偶序节点后面如果存在奇序节点 要断开
        even.next = null;

        // 反转偶序
        ListNode revEvenHead = reverse(evenHead.next);
        // 合并
        return merge(oddHead.next, revEvenHead);
    }

    // 反转链表
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    // 合并链表
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        // flag 为true，合并奇序
        // flag 为false，合并偶序
        boolean flag = true;

        while (l1 != null && l2 != null) {
            if (flag) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            flag = !flag; // flag 反转，交替链接
        }
        // 最后剩余！！
        cur.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static void main(String[] args) {

        String str1 = "1,8,3,6,5,4,7,2"; //去掉首尾[]
        String[] arr1 = str1.split(","); //按,分隔
        ListNode head = new ListNode(Integer.parseInt(arr1[0]));
        ListNode l1 = head;
        for (int i = 1; i < arr1.length; i++) {
            l1.next = new ListNode(Integer.parseInt(arr1[i]));
            l1 = l1.next;
        }

        ListNode result = solution(head); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
