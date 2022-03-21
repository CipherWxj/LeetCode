/**
 * @author: Wxj
 * 25. K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>输入描述:
 * head = [1,2,3,4,5], k = 2
 * <p>输出描述:
 * [2,1,4,3,5]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseKGroup {
    public static ListNode solution(ListNode head, int k) {
        ListNode dummy = new ListNode(); // 虚拟头节点，便于操作
        dummy.next = head;

        ListNode prev = dummy; // 分段头节点的前一节点
        while (head != null) {
            ListNode tail = head; // 分段尾节点
            // 分段操作
            for (int i = 1; i < k; i++) {
                if (tail.next == null) return dummy.next;
                tail = tail.next;
            }

            ListNode next = tail.next; // 分段尾节点的下一节点
            tail.next = null; // 断开，只取要反转的一段
            prev.next = reverse(head); // 反转，并连接到前面已经完成反转的链表
            head.next = next; // 连接到后面还未完成反转的链表，因为已经反转了，head来到了该段的最后
            prev = head; // 更新prev
            head = next; // 更新head，下一段开始
        }
        return dummy.next;
    }

    // 反转操作
    public static ListNode reverse(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请以数组形式输入一个链表：");
        System.out.print("head= ");
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] arr = s.split(",");
        ListNode head = new ListNode(Integer.parseInt(arr[0]));
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(Integer.parseInt(arr[i]));
            cur = cur.next;
        }
        System.out.println("请输入一个整数k：");
        System.out.print("k= ");
        int k = sc.nextInt();
        ListNode res = solution(head, k);
        List<Integer> r = new ArrayList<>();
        while (res != null) {
            r.add(res.val);
            res = res.next;
        }
        System.out.println(r);
    }
}
