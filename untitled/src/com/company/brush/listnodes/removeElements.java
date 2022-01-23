/**
 * @author: Wxj
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>输入描述:
 * head = [1,2,6,3,4,5,6], val = 6
 * <p>输出描述:
 * [1,2,3,4,5]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class removeElements {

    public static ListNode solution(ListNode head, int val) {
        ListNode first = new ListNode(); // 初始化一个头节点，方便链表操作
        // head为空时，直接返回
        if (head != null) {
            first.next = head;
            ListNode temp = first; // 当前节点的上一节点
            ListNode cur = head; // 当前节点
            while (cur != null) {
                if (cur.val == val) {
                    temp.next = cur.next; // 相等，删除当前节点
                } else {
                    temp = temp.next; // 不等，上一节点后移
                }
                cur = cur.next; // 当前节点后移，遍历
            }
        }
        return first.next;
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
        System.out.println("请输入一个正整数：");
        System.out.print("val= ");
        int val = sc.nextInt();
        ListNode result = solution(head, val); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
