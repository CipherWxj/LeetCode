/**
 * @author: Wxj
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字；
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 * <p>输入描述:
 * l1 = [2,4,3]
 * l2 = [5,6,4]
 * <p>输出描述:
 * [7,0,8]
 */
package com.company.addlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddTwoLinkedLists {

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(); //初始虚拟头节点
        ListNode resNode = head; //结果链表从虚拟头节点开始
        int carry = 0;
        while (l1 != null || l2 != null) { //l1和l2都为空时停止运算
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0; //取节点值
            int sum = x + y + carry; //当前节点值与前一节点进位相加
            resNode.next = new ListNode(sum % 10); //将计算结果的个位赋值给结果链表当前节点的下一节点
            resNode = resNode.next; //当前节点指针移动到下一节点
            carry = sum / 10; //计算结果的十位作为进位
            if (l1 != null) {
                l1 = l1.next; //l1指向下一节点
            }
            if (l2 != null) {
                l2 = l2.next; //l2指向下一节点
            }
        }
        if (carry != 0) {
            resNode.next = new ListNode(carry); //最终进位作为链表的末尾节点
        }
        return head.next; //返回头节点之后的链表即为结果链表
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ListNode> l = new ArrayList<>(2); //链表存储容器
        for (int i = 1; i < 3; i++) {
            ListNode l0 = new ListNode();
            ListNode curr = l0;
            System.out.print("l" + i + "=");
            String input = sc.nextLine(); //输入string
            String str = input.substring(1, input.length() - 1); //去掉首尾[]
            String[] arr = str.split(","); //按,分隔
            for (int j = 0; j < arr.length; j++) {
                curr.next = new ListNode(Integer.parseInt(arr[j])); //节点赋值
                curr = curr.next;
            }
            l.add(l0.next);
        }
        ListNode result = solution(l.get(0), l.get(1)); //调用算法，返回链表
        List<Integer> r = new ArrayList<>(); //初始化List
        while (result != null) {
            r.add(result.val); //赋值
            result = result.next;
        }
        System.out.println(Arrays.toString(r.toArray())); //转string打印输出
    }
}
