package com.company.DataStructure.LinkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        /**
         * 测试
         */

        // 初始化节点
        Nodes player1 = new Nodes(1, "Durant", "SF");
        Nodes player2 = new Nodes(2, "Curry", "PG");
        Nodes player3 = new Nodes(3, "Antetokounmpo", "PF");
        Nodes player4 = new Nodes(4, "George", "SG");
        Nodes player5 = new Nodes(5, "Jokic", "C");

        // 创建链表
        ManageLinkedLists playerLinkedLists = new ManageLinkedLists();
//
//        // 添加
//        playerLinkedLists.add(player1);
//        playerLinkedLists.add(player2);
////        playerLinkedLists.add(player3);
//        playerLinkedLists.add(player4);
//        playerLinkedLists.add(player5);
//        System.out.println("链表初始化完成！");
//        playerLinkedLists.show();
//
//        // 根据 num 添加
//        playerLinkedLists.addByNum(player3);
//        System.out.println("已添加！");
//        playerLinkedLists.show();
//
//        // 根据 num 修改
//        Nodes newPlayers = new Nodes(4, "DeRozan", "SF");
//        playerLinkedLists.update(newPlayers);
//        System.out.println("已修改！");
//        playerLinkedLists.show();
//
//        // 根据 num 删除
//        playerLinkedLists.delete(4);
//        System.out.println("已删除！");
//        playerLinkedLists.show();
//
//        // 获取链表长度
//        int length = playerLinkedLists.getLength(playerLinkedLists.getHead());
//        System.out.printf("链表的长度为：%d\n", length);
    }
}

class Nodes {
    /**
     * 节点类，每个对象就是一个节点
     */
    public int num;
    public String name;
    public String major;
    public Nodes next;
    public Nodes pre;

    // 构造器
    public Nodes(int num, String name, String major) {
        this.num = num;
        this.name = name;
        this.major = major;
    }

    // toString 方便打印显示
    @Override
    public String toString() {
        return "DoubleNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}


class ManageLinkedLists {
    /**
     * 链表管理类
     */
    Nodes headNodes = new Nodes(0, "", ""); // 初始化头节点,不存放具体数据

    public Nodes getHead() {
        /**
         * 获取头节点
         */
        return headNodes;
    }

    public void add(Nodes nodes) {
        /**
         * 添加节点，添加到链表尾部
         */

        Nodes temp = headNodes; // 辅助节点指针

        // 遍历链表，找到链表尾部
        while (true) {
            if (temp.next == null) { // 遍历完整个链表
                break;
            }
            temp = temp.next;
        }
        temp.next = nodes;
        nodes.pre = temp; // 添加新的节点
    }

    public void addByNum(Nodes nodes) {
        /**
         * 按照 num 顺序添加
         */

        Nodes temp = headNodes; // 辅助节点指针
        boolean flag = false; // 标识所添加节点的编号 num 是否已经存在，true：存在

        // 遍历链表
        while (true) {
            if (temp.next == null) { // 遍历完整个链表
                break;
            }
            if (temp.next.num > nodes.num) { // 插入位置
                break;
            } else if (temp.next.num == nodes.num) { // 编号已存在
                flag = true; // 找到 num 对应的节点，flag标记
                break;
            }
            temp = temp.next; // 后移，遍历
        }

        //判断flag，执行增加操作
        if (flag) {
            System.out.printf("当前编号 %d 已存在\n", nodes.num);
        } else {
            // 编号不存在，插入在 temp 的后面
            nodes.next = temp.next;
            temp.next = nodes;
            temp.next.pre = nodes;
            nodes.pre = temp;
        }
    }

    public void update(Nodes newNodes) {
        /**
         * 根据 num 修改节点
         */
        if (headNodes.next == null) {
            System.out.print("链表为空！");
        }

        Nodes temp = headNodes; // 辅助节点指针
        boolean flag = false; // 标识所修改节点的编号 num 是否已经存在，true：存在

        // 遍历链表
        while (true) {
            if (temp == null) { // 遍历完整个链表    ！！！区别于添加！！！
                break;
            }
            if (temp.num == newNodes.num) {
                flag = true; // 找到 num 对应的节点，flag标记
                break;
            }
            temp = temp.next; // 后移，遍历
        }

        //判断flag，执行修改操作
        if (flag) {
            temp.name = newNodes.name;
            temp.major = newNodes.major;
        } else {
            System.out.printf("当前编号 %d 不存在\n", newNodes.num);
        }
    }

    public void delete(int num) {
        /**
         * 根据 num 删除节点
         */
        Nodes temp = headNodes; // 辅助节点指针
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
            temp.next = temp.next.next;
            if (temp.next.next != null) {  //末尾节点不需要 pre
                temp.next.next.pre = temp;
            }
        } else {
            System.out.printf("当前编号 %d 不存在\n", num);
        }
    }

    public void show() {
        /**
         * 显示整个链表
         */
        Nodes temp = headNodes; // 辅助节点指针

        // 遍历链表
        while (true) {
            if (temp == null) { // 遍历完整个链表    ！！！类似于修改，区别于添加！！！
                break;
            }
            System.out.println(temp); // 打印
            temp = temp.next; // 后移，遍历
        }
    }

    public int getLength(Nodes nodes) {
        /**
         * 获取链表的长度  (带头节点的链表，头节点不存放具体数据)
         */
        if (nodes.next == null) {
            return 0;
        }

        int len = 0; // 计数器

        Nodes temp = nodes.next; // 辅助节点指针
        while (temp != null) {
            len++;
            temp = temp.next; // 遍历
        }
        return len;
    }
}
