/**
 * @author: Wxj
 * 将两个 升序链表 合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>输入描述:
 * l1 = [1,2,4], l2 = [1,3,4]
 * <p>输出描述:
 * [1,1,2,3,4,4]
 */
package com.company.brush.listnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeTwoLinkedLists {

    public static ListNode solution(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(); // 初始化结果链表的头结点（不存数据）
        ListNode cur = head; // 结果链表的当前节点指针

        while (l1 != null && l2 != null) { // 两者均不为空时遍历
            if (l1.val <= l2.val) { // l1 节点的值 <= l2 节点的值
                // 新建节点，并将较小值赋给它
                // （如果直接赋值给cur那么下面cur指针右移将报空指针异常错误）
                cur.next = new ListNode(l1.val);
                l1 = l1.next; // l1 节点右移
            } else { // l1 节点的值 > l2 节点的值
                cur.next = new ListNode(l2.val);
                l2 = l2.next; // l2 节点右移
            }
            cur = cur.next; // 结果链表节点右移
        }
        // 比较完之后若还有非空链表则直接链接到结果链表
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next; // 由于头节点未赋值，返回除头节点以外的结果链表
    }

    public static void main(String[] args) {

        System.out.println("请以数组形式输入两个链表：");
        Scanner sc = new Scanner(System.in);
        System.out.print("l1=");
        String s1 = sc.nextLine();
        String str1 = s1.substring(1, s1.length() - 1); //去掉首尾[]
        String[] arr1 = str1.split(","); //按,分隔
        ListNode l1 = new ListNode();
        ListNode c1 = l1;
        for (int i = 0; i < arr1.length; i++) {
            c1.next = new ListNode(Integer.parseInt(arr1[i]));
            c1 = c1.next;
        }

        System.out.print("l2=");
        String s2 = sc.nextLine();
        String str2 = s2.substring(1, s2.length() - 1); //去掉首尾[]
        String[] arr2 = str2.split(","); //按,分隔
        ListNode l2 = new ListNode();
        ListNode c2 = l2;
        for (int i = 0; i < arr2.length; i++) {
            c2.next = new ListNode(Integer.parseInt(arr2[i]));
            c2 = c2.next;
        }

        ListNode result = solution(l1.next, l2.next); // 调用算法，返回链表
        List<Integer> r = new ArrayList<>(); // 初始化List
        while (result != null) {
            r.add(result.val); // 赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
