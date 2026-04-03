package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangxinjian
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>输入描述:
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>输出描述:
 * [null,null,null,null,-3,null,0,-2]
 */
public class MinStack {
    /**
     * 这个题一开始看不懂
     * 其实就是给栈提供一个最小值查询的功能，封装成一个类
     */

    // 对外封装提供最小值查询功能的栈
    Deque<Integer> minStack;

    // 维护一个辅助栈，保持元素与minStack中元素一一对应
    // 辅助栈栈顶元素始终是 minStack栈 内的最小值
    Deque<Integer> helpStack;

    public MinStack() {
        minStack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void push(int val) {
        // 添加
        minStack.push(val);
        // 因为 要求常数级时间内找到最小值，所以这个值我们必须在添加的时候就进行操作保存
        // 如果插入的值比helpStack顶元素小，更新helpStack栈顶元素（最小值）
        if (helpStack.isEmpty() || val < helpStack.peek()) {
            helpStack.push(val);
        } else { // 如果插入的值比helpStack顶元素大，最小值还是原来helpStack栈顶元素，再添加一遍，始终保持两个栈元素一一对应
            helpStack.push(helpStack.peek());
        }
    }

    public void pop() {
        // 同步出栈
        minStack.pop();
        helpStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }
}
