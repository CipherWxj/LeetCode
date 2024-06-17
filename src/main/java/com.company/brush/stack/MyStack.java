/**
 * @author: Wxj
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * <p>输入描述:
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * <p>输出描述:
 * [null, null, null, 2, 2, false]
 */
package com.company.brush.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> mQueue; // 数据队列
    Queue<Integer> tQueue; // 缓存队列

    public MyStack() {
        mQueue = new LinkedList<>();
        tQueue = new LinkedList<>();
    }

    // 直接将数字加到数据队列的末尾
    public void push(int x) {
        mQueue.offer(x);
    }

    // 依次出数据队列，入缓存队列
    // 直到数据队列为空，记录最后一个数据，即为栈顶元素（队列末尾）
    // 该栈顶元素不需要入缓存队列，出栈
    // 还要将缓存的数据重新放回数据队列
    public int pop() {
        int x = mQueue.poll();
        while(!mQueue.isEmpty()) {
            tQueue.offer(x);
            x = mQueue.poll();
        }
        while(!tQueue.isEmpty()) {
            mQueue.offer(tQueue.poll());
        }
        return x;
    }

    // 依次出数据队列，入缓存队列
    // 直到数据队列为空，记录最后一个数据，即为栈顶元素（队列末尾）
    // 该栈顶元素也要入缓存队列
    // 还要将缓存的数据重新放回数据队列
    public int top() {
        int x = mQueue.poll();
        while(!mQueue.isEmpty()) {
            tQueue.offer(x);
            x = mQueue.poll();
        }
        tQueue.offer(x);
        while(!tQueue.isEmpty()) {
            mQueue.offer(tQueue.poll());
        }
        return x;

    }

    // 直接查看数据队列
    public boolean empty() {
        return mQueue.isEmpty();
    }
}
