/**
 * @author: Wxj
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>输入描述:
 * head = [-1,5,3,4,0], k = 2
 * <p>输出描述:
 * [4,0]
 */
package com.company.brush.listnodes;

public class GetKthFromEnd {

    // 顺序查找
    public ListNode solution1(ListNode head, int k) {
        // 先求出链表的长度
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 特殊情况
        if (k > length) return null;
        // 倒数第 k 个节点，就是顺数第 length - k + 1 个节点
        // 初始化遍历起始位置为 head
        // 后面遍历 length - k 次就可到达
        ListNode target = head;
        for (int i = 0; i < length - k; i++) {
            target = target.next;
        }
        return target;
    }

    // 快慢指针
    public ListNode solution2(ListNode head, int k) {
        // 先让快指针遍历 k 次，到达顺序第 k + 1 个节点
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }else return null;
        }
        // 快指针和慢指针同时遍历
        // 直到整个链表遍历完，fast == null，此时 solw 到达倒数第 k 个节点
        // fast 和 slow 之间的距离是 k
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
