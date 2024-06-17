/**
 * @author: Wxj
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>输入描述:
 * lists = [[1,4,5],[1,3,4],[2,6]]
 * <p>输出描述:
 * [1,1,2,3,4,4,5,6]
 */
package com.company.brush.listnodes;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    // 分治思想
    public static ListNode solution1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    // 比较类
    public static class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            // 从小到大
            return this.val - status2.val;
        }
    }


    public ListNode solution2(ListNode[] lists) {
        // 优先队列
        Queue<Status> queue = new PriorityQueue<Status>();

        // 将链表加入队列（实际加的是头节点）
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // 遍历
        while (!queue.isEmpty()) {
            // 队列首元素最小
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            // 遍历链表
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
