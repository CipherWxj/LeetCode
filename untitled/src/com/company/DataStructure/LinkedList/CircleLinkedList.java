package com.company.DataStructure.LinkedList;

public class CircleLinkedList {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleListNode circleListNode = new CircleListNode();
        circleListNode.createCirListNode(5); // 加入5个节点
        circleListNode.show();

        //测试Josephus
        circleListNode.josephus(5, 1, 2);
    }
}

class ListNode {
    /**
     * 节点类
     */
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }
}

class CircleListNode {
    /**
     * 环形链表操作类
     */
    ListNode first = null; // 初始化第一个节点

    public void createCirListNode(int num) {
        /**
         * 创建有 num 个节点的环形链表
         */
        ListNode cur = first;

        for (int i = 1; i < num + 1; i++) {
            ListNode listNode = new ListNode(i);
            if (i == 1) {
                first = listNode;
                listNode.next = first;
                cur = first;
            } else {
                cur.next = listNode;
                listNode.next = first;
                cur = cur.next;
            }
        }
    }

    public void show() {
        /**
         * 遍历显示
         */
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        ListNode cur = first; // 辅助指针

        while (true) {
            System.out.println("节点" + cur.value);
            if (cur.next == first) {// 说明已经遍历完毕
                break;
            }
            cur = cur.next; // curBoy后移,遍历
        }
    }

    public void josephus(int nums, int startNum, int countNum) {
        /**
         * ！！！约瑟夫问题：
         * 所有人围成一圈，顺时针报数，每次报到 q 的人将被kill掉，被kill掉的人将从圈内被移走，
         * 然后从被kill掉的下一个人重新从 1 开始报数，报到q，被kill，直到剩余一人。
         *
         * @param nums     总人数
         * @param startNum 表示从第几个小孩开始报数
         * @param countNum 报到被kill的数（q）
         */
        // 先对数据进行校验
        if (first == null || startNum < 1 || startNum > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        ListNode last = first; // 辅助指针, ！！！方便删除节点后链表的链接！！！

        // 使 辅助指针 指向 first的上一节点
        while (true) {
            if (last.next == first) { // 说明 cur 指向最后一个节点
                break;
            }
            last = last.next;
        }

        // 报数前，先让 first 和 cur 移动 startNum-1次，使 first 指向startNum
        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            last = last.next;
        }

        // 报数时，让 first 和 cur 同时的移动 countNum-1 次, 执行出圈操作
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (last == first) { //说明圈中只剩下一个节点
                break;
            }
            //让 first 和 cur 同时 的移动 countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.next;
                last = last.next;
            }
            //这时first指向的节点，就是要出圈的节点
            System.out.printf("No.%d is killed.\n", first.value);
            //这时将first指向的节点出圈
            first = first.next;
            last.next = first;
        }
        System.out.printf("最后存活的是%d号\n", first.value);
    }
}