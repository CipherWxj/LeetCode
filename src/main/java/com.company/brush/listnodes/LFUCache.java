/**
 * @author: Wxj
 * 460. LFU 缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；
 * 如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>输入描述:
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * <p>输出描述:
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 */
package com.company.brush.listnodes;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    Map<Integer, Node> cache ; // 存储缓存的内容
    Map<Integer, DoublyLinkedList> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                DoublyLinkedList minFreqLinkedList = freqMap.get(min);
                cache.remove(minFreqLinkedList.tail.prev.key);
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.prev); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            DoublyLinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new DoublyLinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addNode(newNode);
            size++;
            min = 1;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        DoublyLinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        if (freq == min && linkedList.head.next == linkedList.tail) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new DoublyLinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);
    }
}

class Node {
    int key;
    int value;
    int freq = 1;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

