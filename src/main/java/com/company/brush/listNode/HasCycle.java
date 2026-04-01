package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>输入描述:
 * head = [3,2,0,-4], pos = 1
 * <p>输出描述:
 * true
 */
public class HasCycle {
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // 快慢指针，快指针一次走两步，慢指针一次走一步
        // 如果有环，快指针最终会追上慢指针，否则快指针会先到达链表末尾
        // 为了能让 while 执行，将 慢指针 设置为 头节点，快指针 设为 第二个节点！！！
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }
}
