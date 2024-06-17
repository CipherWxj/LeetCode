/**
 * @author: Wxj
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。
 * 返回 已排序的链表 。
 * <p>输入描述:
 * head = [1,2,3,3,4,4,5]
 * <p>输出描述:
 * [1,2,5]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplicates2 {
    public static ListNode solution(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode same;
        // 终止条件 cur.next 到最后一个节点
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                same = cur.next; // 记录重复数字的节点
                // 与重复数字相等则删除
                while (cur.next != null && cur.next.val == same.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 递归
    public static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) return head;
        // 在 递 的过程中删除
        if (head.val == head.next.val) {
            // 删除 与 head.val 相等的节点
            while (head.next != null && head.val == head.next.val){
                head.next = head.next.next;
            }
            // 删除 head 节点
            head = solution2(head.next);
        }else {
            head.next = solution2(head.next);
        }
        return head;
    }

    public static void main(String[] args) {

        System.out.println("请以数组形式输入一个升序链表：");
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

        ListNode result = solution2(head); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
