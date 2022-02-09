/**
 * @author: Wxj
 * 83. 删除排序链表中的重复元素
 * 存在一个按 升序排列 的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * <p>输入描述:
 * [1,1,2,3,3]
 * <p>输出描述:
 * [1,2,3]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeleteDuplicates {

    public static ListNode solution(ListNode head) {
        // head为空时，直接返回
        if (head != null) {
            ListNode temp = head; // 指向上一个不重复的节点
            ListNode cur = head.next; // 当前节点，用于遍历
            while (cur != null) {
                if (cur.val == temp.val) {
                    // 相等，先将cur右移，然后让temp.next指向cur，达到删除的目的
                    cur = cur.next;
                    temp.next = cur;
                } else {
                    // 不相等，先将temp右移，再将cur右移
                    temp = cur;
                    cur = cur.next;
                }
            }
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

        ListNode result = solution(head); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
