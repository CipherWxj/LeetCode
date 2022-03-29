/**
 * @author: Wxj
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>输入描述:
 * head = [1,2,3,4,5], left = 2, right = 4
 * <p>输出描述:
 * [1,4,3,2,5]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseBetween {

    public static ListNode solution(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        // 分段
        // 段头 head
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        head = prev.next;

        // 段尾 tail
        ListNode tail = head;
        for (int j = 0; j < (right - left); j++) {
            tail = tail.next;
        }

        ListNode next = tail.next;

        // 将该段链表 反转,连接回原链表
        tail.next = null;
        prev.next = ReverseList.solution1(head);
        head.next = next;
        return dummy.next;
    }

    // 头插法
    public static ListNode solution2(ListNode head, int left, int right){
        if (head == null || head.next==null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        // prev 始终指向 left 前一个节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // cur 始终指向该节点，但该节点依次后移
        ListNode cur = prev.next;

        for (int j = 0; j < right - left; j++) {
            ListNode next = cur.next; // 标记 往前插的节点
            cur.next = next.next; // 断开 next，cur 指向 next.next
            next.next = prev.next; // next 前插
            prev.next = next; // next 重新连接
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("请以数组形式输入一个链表：");
        Scanner sc = new Scanner(System.in);
        System.out.print("head= ");
        String s1 = sc.nextLine();
        String str1 = s1.substring(1, s1.length() - 1); //去掉首尾[]
        String[] arr1 = str1.split(","); //按,分隔
        ListNode head = new ListNode(Integer.parseInt(arr1[0]));
        ListNode l1 = head;
        for (int i = 1; i < arr1.length; i++) {
            l1.next = new ListNode(Integer.parseInt(arr1[i]));
            l1 = l1.next;
        }
        System.out.print("left= ");
        int left = sc.nextInt();
        System.out.print("right= ");
        int right = sc.nextInt();
        ListNode result = solution(head, left, right); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(r);
    }
}
