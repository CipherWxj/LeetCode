package com.company.DataStructure.LinkedList;

import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        /**
         * 测试
         */

        // 初始化节点
        Node player1 = new Node(1, "Durant", "SF");
        Node player2 = new Node(2, "Curry", "PG");
        Node player3 = new Node(3, "Antetokounmpo", "PF");
        Node player4 = new Node(4, "George", "SG");
        Node player5 = new Node(5, "Jokic", "C");

        // 创建链表
        ManageLinkedList playerLinkedList = new ManageLinkedList();
//
//        // 添加
//        playerLinkedList.add(player1);
//        playerLinkedList.add(player2);
////        playerLinkedList.add(player3);
//        playerLinkedList.add(player4);
//        playerLinkedList.add(player5);
//        System.out.println("链表初始化完成！");
//        playerLinkedList.show();
//
//        // 根据 num 添加
//        playerLinkedList.addByNum(player3);
//        System.out.println("已添加！");
//        playerLinkedList.show();
//
//        // 根据 num 修改
//        Node newPlayer = new Node(4, "DeRozan", "SF");
//        playerLinkedList.update(newPlayer);
//        System.out.println("已修改！");
//        playerLinkedList.show();
//
//        // 根据 num 删除
//        playerLinkedList.delete(4);
//        System.out.println("已删除！");
//        playerLinkedList.show();
//
//        // 反转
//        playerLinkedList.reverseList(playerLinkedList.getHead());
//        System.out.println("已反转！");
//        playerLinkedList.show();
//
//        // 获取链表长度
//        int length = playerLinkedList.getLength(playerLinkedList.getHead());
//        System.out.printf("链表的长度为：%d\n", length);
//
//        // 查找倒数节点
//        Node selectedNode = playerLinkedList.fingLastIndexNode(playerLinkedList.getHead(), 3);
//        System.out.println(selectedNode);
//
//        // 倒序打印
//        playerLinkedList.reversePrint(playerLinkedList.getHead());

        // 合并有序链表
        ManageLinkedList node1 = new ManageLinkedList();
        node1.add(player1);
        node1.add(player3);
        node1.add(player5);
        ManageLinkedList node2 = new ManageLinkedList();
        node2.add(player2);
        node2.add(player4);
        System.out.println(node1.headNode.next);
        System.out.println(node2.headNode.next);
        Node mergedNode = playerLinkedList.mergeTwoListNode(node1.headNode.next, node2.headNode.next);
        System.out.println(mergedNode);
    }
}

class Node {
    /**
     * 节点类，每个对象就是一个节点
     */
    public int num;
    public String name;
    public String major;
    public Node next;

    // 构造器
    public Node(int num, String name, String major) {
        this.num = num;
        this.name = name;
        this.major = major;
    }

    // toString 方便打印显示
    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", next=" + next +
                '}';
    }
}

class ManageLinkedList {
    /**
     * 链表管理类
     */
    Node headNode = new Node(0, "", ""); // 初始化头节点,不存放具体数据

    public Node getHead() {
        /**
         * 获取头节点
         */
        return headNode;
    }

    public void add(Node node) {
        /**
         * 添加节点，添加到链表尾部
         */

        Node temp = headNode; // 辅助节点指针

        // 遍历链表，找到链表尾部
        while (true) {
            if (temp.next == null) { // 遍历完整个链表
                break;
            }
            temp = temp.next;
        }
        temp.next = node; // 添加新的节点
    }

    public void addByNum(Node node) {
        /**
         * 按照 num 顺序添加
         */

        Node temp = headNode; // 辅助节点指针
        boolean flag = false; // 标识所添加节点的编号 num 是否已经存在，true：存在

        // 遍历链表
        while (true) {
            if (temp.next == null) { // 遍历完整个链表
                break;
            }
            if (temp.next.num > node.num) { // 插入位置
                break;
            } else if (temp.next.num == node.num) { // 编号已存在
                flag = true; // 找到 num 对应的节点，flag标记
                break;
            }
            temp = temp.next; // 后移，遍历
        }

        //判断flag，执行增加操作
        if (flag) {
            System.out.printf("当前编号 %d 已存在\n", node.num);
        } else {
            // 编号不存在，插入在 temp 的后面
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void update(Node newNode) {
        /**
         * 根据 num 修改节点
         */
        if (headNode.next == null) {
            System.out.printf("链表为空！");
        }

        Node temp = headNode; // 辅助节点指针
        boolean flag = false; // 标识所修改节点的编号 num 是否已经存在，true：存在

        // 遍历链表
        while (true) {
            if (temp == null) { // 遍历完整个链表    ！！！区别于添加！！！
                break;
            }
            if (temp.num == newNode.num) {
                flag = true; // 找到 num 对应的节点，flag标记
                break;
            }
            temp = temp.next; // 后移，遍历
        }

        //判断flag，执行修改操作
        if (flag) {
            temp.name = newNode.name;
            temp.major = newNode.major;
        } else {
            System.out.printf("当前编号 %d 不存在\n", newNode.num);
        }
    }

    public void delete(int num) {
        /**
         * 根据 num 删除节点
         */
        Node temp = headNode; // 辅助节点指针
        boolean flag = false; // 标识所删除节点的编号 num 是否已经存在，true：存在

        // 遍历链表
        while (true) {
            if (temp.next == null) { // 遍历完整个链表    ！！！类似于添加，区别于修改！！！
                break;
            }
            if (temp.next.num == num) {
                flag = true; // 找到 num 对应的节点，flag标记
                break;
            }
            temp = temp.next; // 后移，遍历
        }

        //判断flag，执行删除操作
        if (flag) {
            temp.next = temp.next.next; // 下一个向上赋值，即删除上一个
        } else {
            System.out.printf("当前编号 %d 不存在\n", num);
        }
    }

    public void show() {
        /**
         * 显示整个链表
         */
        Node temp = headNode; // 辅助节点指针

        // 遍历链表
        while (true) {
            if (temp == null) { // 遍历完整个链表    ！！！类似于修改，区别于添加！！！
                break;
            }
            System.out.println(temp); // 打印
            temp = temp.next; // 后移，遍历
        }
    }

    public int getLength(Node node) {
        /**
         * 获取链表的长度  (带头节点的链表，头节点不存放具体数据)
         */
        if (node.next == null) {
            return 0;
        }

        int len = 0; // 计数器

        Node temp = node.next; // 辅助节点指针
        while (temp != null) {
            len++;
            temp = temp.next; // 遍历
        }
        return len;
    }

    public Node fingLastIndexNode(Node node, int index) {
        /**
         * 查找链表的 倒数 第index个 节点  (带头节点的链表，头节点不存放具体数据)
         */
        if (node.next == null) {
            return null;
        }

        int size = getLength(node); // 获取链表长度

        // 判断索引是否超出链表长度范围
        if (index <= 0 || index > size) {
            return null;
        }

        Node temp = node.next; // 辅助节点指针

        for (int i = 0; i < size - index; i++) { // 从前往后遍历
            temp = temp.next;
        }
        return temp;
    }

    public void reversePrint(Node node) {
        /**
         * 倒序打印，即从未到头打印链表  (带头节点的链表，头节点不存放具体数据)
         */
        if (node.next == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<Node>(); // 创建链表栈
        Node temp = node.next; // 辅助节点指针

        while (temp != null) {
            nodeStack.push(temp); // 入栈
            temp = temp.next; // 遍历
        }

        while (nodeStack.size() > 0) {
            System.out.println(nodeStack.pop()); // 依次出栈
        }
    }

    public void reverseList(Node node) {
        /**
         * 反转链表
         */
        if (node.next == null || node.next.next == null) {
            return;
        }

        Node cur = node.next; // 辅助节点指针,当前节点
        Node next = null; // 辅助节点指针,下一节点

        Node reverseHead = new Node(0, "", ""); // 初始化反转链表的头节点

        while (cur != null) {
            next = cur.next; // 暂时存储原链表当前节点的下一节点
            cur.next = reverseHead.next; // 当前节点 指向 反转链表的最前端
            reverseHead.next = cur; // 反转链表的头节点 指向 当前节点
            cur = next; // 当前节点右移，遍历
        }

        node.next = reverseHead.next; // 原头节点 指向 反转链表
    }

    public Node mergeTwoListNode(Node node1, Node node2) {
        /**
         * 根据 num 合并两个！有序！列表
         * 不考虑无实际意义的头节点
         */
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        Node result = headNode; // 结果存储链表

        // 原链表有序，依次比较，递归
        if (node1.num < node2.num) {
            result = node1;
            result.next = mergeTwoListNode(node1.next, node2);
        } else {
            result = node2;
            result.next = mergeTwoListNode(node1, node2.next);
        }
        return result;
    }
}

