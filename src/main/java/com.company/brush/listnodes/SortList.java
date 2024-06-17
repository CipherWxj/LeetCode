/**
 * @author: Wxj
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>输入描述:
 * head = [-1,5,3,4,0]
 * <p>输出描述:
 * [-1,0,3,4,5]
 */
package com.company.brush.listnodes;

public class SortList {

    // 归并排序
    // 分治
    public ListNode mergeSort(ListNode head) {
        // 终止条件：分到单个节点为止
        if (head == null || head.next == null) return head;
        // 快慢指针，找到链表中点，分段
        // 奇数个 slow 位于第 (n/2)+1 个；偶数个 slow 位于第 (n/2) 个
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode halfHead = slow.next;
        slow.next = null;
        // 递归
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(halfHead);
        // 合并
        return merge(left, right);
    }

    // 合并
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    // 快速排序
    public ListNode quickSort(ListNode head) {
        // 终止条件：分到单个节点为止
        if (head == null || head.next == null) return head;
        // 取头节点作为切分点
        int pivot = head.val;
        // 切分点左右两侧分割成两个链表
        ListNode leftHead = new ListNode(), rightHead = new ListNode();
        // 找到 切分点（head）的位置
        ListNode leftCur = leftHead, rightCur = rightHead, cur = head.next;
        while (cur != null) {
            if (cur.val < pivot) {
                leftCur.next = cur;
                leftCur = leftCur.next;
            } else {
                rightCur.next = cur;
                rightCur = rightCur.next;
            }
            cur = cur.next;
        }
        // 将 head 连接到左侧链表的末尾
        // head 的位置不会再变化，左侧其他元素都比 head 小
        leftCur.next = head;
        // 切分
        head.next = null;
        rightCur.next = null;
        // 左右递归
        ListNode left = quickSort(leftHead.next);
        // 将右侧链表 链接 到切分点的后面
        head.next = quickSort(rightHead.next);

        return left;
    }

    // 插入排序
    public ListNode insertSort(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 当前插入的节点
        ListNode cur = head.next;
        // 已经排序完的最后一个节点
        ListNode lastSorted = head;
        while (cur != null) {
            // 标记下一个待操作的节点
            ListNode next = cur.next;
            // 先比较已经排序的最大值，如果当前节点还要大，不用动
            // 这个必须有，一方面简化运算，一方面能将 lastSorted 摘出来，避免后面从前往后遍历链接出现错误
            if (cur.val >= lastSorted.val) {
                lastSorted = cur;
            } else {
                // 数组插入排序我们一直是从后往前比较
                // 由于单链表没有前驱节点，只能从前往后遍历
                // 为了方便节点的插入，我们比较的一直是cur 和 compare.next
                ListNode compare = dummy;
                // 能运行到这说明 cur 一定能被插入，while不会进入死循环，最差也是 lastSorted 前一位
                while (cur.val >= compare.next.val) {
                    compare = compare.next;
                }
                // 节点插入四步走：前（后）后前
                // 先将节点从原链表摘出，保持原链表顺序不变，先断开前面指针，后断开后面指针
                lastSorted.next = next;
//                cur.next = null;
                // 再将节点插入，先链接后面指针，再链接前面指针
                cur.next = compare.next;
                compare.next = cur;
            }
            cur = next;
        }
        return dummy.next;
    }
}
