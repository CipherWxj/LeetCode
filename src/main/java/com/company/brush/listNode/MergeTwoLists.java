package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 21. 合并两个有序链表
 * 将两个 升序链表 合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>输入描述:
 * l1 = [1,2,4], l2 = [1,3,4]
 * <p>输出描述:
 * [1,1,2,3,4,4]
 */
public class MergeTwoLists {
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        // 创建虚拟头节点
        ListNode dummy = new ListNode();
        // 遍历
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 连接剩余节点
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = mergeTwoLists(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
