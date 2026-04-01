package com.company.brush.listNode;

/**
 * @author: wangxinjian
 * 142. 环形链表 II
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>输入描述:
 * head = [3,2,0,-4], pos = 1
 * <p>输出描述:
 * 返回索引为 1 的链表节点
 */
public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        // 快慢指针
        // 假设链表中环外部分的长度为a。slow指针进入环后，又走了b的距离与fast相遇，剩余环内的距离为c：
        // 此时，fast指针已经走完了环的n圈，因此它走过的总距离为：a+n(b+c)+b=a+(n+1)b+nc，slow指针走过的距离为：a+b，
        // 由于fast指针的速度是slow指针速度的2倍，因此有：a+(n+1)b+nc=2(a+b)，变形可得a=c+(n-1)(b+c)，
        // 即从相遇点到环入口点的距离c加上n-1圈环的长度b+c，恰好等于从头节点到环入口点的距离a。
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else { // 没有环
                return null;
            }
            slow = slow.next;
            // 快慢指针相遇，说明有环，slow指针继续在环内走c+(n-1)(b+c)，search指针从头节点开始走a，相遇点即为环入口点
            if (slow == fast) {
                ListNode search = head;
                while (search != slow) {
                    search = search.next;
                    slow = slow.next;
                }
                return search;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
