/**
 * @author: Wxj
 * 146. LRU 缓存
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>输入描述:
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3, 3],[2],[4, 4],[1],[3],[4]]
 * <p>输出描述:
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 */
package com.company.brush.listnodes;

import java.util.*;

public class LRUCache {
    Map<Integer, DoubleListNode> cache = new HashMap<Integer, DoubleListNode>(); // 利用哈希表来查找位置
    int size; // 计数器，记录已添加的数量
    int capacity; // 最大容量
    DoubleListNode head, tail; // 虚拟头、尾节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 初始化双向链表
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleListNode curNode = cache.get(key);
        // key不存在
        if (curNode == null) {
            return -1;
        }
        // key存在
        moveToHead(curNode); // 将该节点放到双向链表的头部
        return curNode.value; // 返回关键字key的值
    }

    public void put(int key, int value) {
        DoubleListNode curNode = cache.get(key);
        // key不存在
        if (curNode == null) {
            DoubleListNode newNode = new DoubleListNode(key, value); // 新建节点
            cache.put(key, newNode); // 放入哈希表中
            addToHead(newNode); // 将该节点放到头部
            ++size; // 计数器+1
            // 判断是否超过最大容量
            if (size > capacity) {
                DoubleListNode tailNode = tail.prev; // 获取尾部节点
                cache.remove(tailNode.key); // 删除哈希表中的记录
                removeNode(tailNode); // 删除尾部节点
                --size; // 计数器-1
            }
        }
        // key存在
        else {
            curNode.value = value; // 修改关键字key的值
            moveToHead(curNode); // 移动到头部
        }
    }

    // 添加节点到双向链表的头部
    private void addToHead(DoubleListNode node) {
        // 先将节点加入链表
        node.prev = head;
        node.next = head.next;
        // 再将前后节点与新增节点连接   ！！注意顺序！！
        head.next.prev = node;
        head.next = node;
//        head.next = node;
//        head.next.next.prev = node;
    }

    // 移除节点
    private void removeNode(DoubleListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
//        // 不管也行！！！
//        node.next = null;
//        node.prev = null;
    }

    private void moveToHead(DoubleListNode node) {
        // 先移除
        removeNode(node);
        // 后添加到头部
        addToHead(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        String[] arr1 = s1.split(",");
        String s2 = sc.nextLine();
        s2 = s2.substring(1, s2.length() - 1);
        String[] arr2 = s2.split("],");
        List<Integer> output = new ArrayList<>();
        LRUCache cache = new LRUCache(Integer.parseInt(String.valueOf(arr2[0].charAt(1))));
        output.add(null);
        for (int i = 1; i < arr1.length; i++) {
            String method = arr1[i].substring(1, arr1[i].length() - 1);
            String input = arr2[i].substring(1);
            int key = Integer.parseInt(String.valueOf(input.charAt(0)));
            if (method.equals("put")) {
                int value = Integer.parseInt(String.valueOf(input.charAt(2)));
                cache.put(key, value);
                output.add(null);
            } else if (method.equals("get")) {
                output.add(cache.get(key));
            }
        }
        System.out.println(output);
    }
}

/**
 * 双向链表类
 */
class DoubleListNode {
    int key;
    int value;
    DoubleListNode prev; // 指向上一节点
    DoubleListNode next; // 指向下一节点

    DoubleListNode() {
    }

    DoubleListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
