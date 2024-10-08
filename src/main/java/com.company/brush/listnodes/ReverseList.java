/**
 * @author: Wxj
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>输入描述:
 * head = [1,2,6,3,4,5]
 * <p>输出描述:
 * [5，4，3，2，1]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseList {

    // 递归
    public static ListNode solution1(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归深入到最后一个节点
        ListNode temp = solution1(head.next);
        head.next.next = head; // 反转操作
        head.next = null; // 断开原指针
        return temp;
    }

    // 迭代
    public static ListNode solution2(ListNode head) {
        // 指向原链表上一个节点的指针
        ListNode last = null;
        // 遍历
        while (head != null) {
            // 当前处理的节点
            ListNode cur = head;
            // 后移
            head = head.next;
            // 反转
            cur.next = last;
            // 更新反转链表的头节点
            last = cur;
        }
        return last;
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

        ListNode result = solution1(head); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
