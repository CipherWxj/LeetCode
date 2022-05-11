/**
 * @author: Wxj
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
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> minStack;
    // 因为 要求常数级时间内找到最小值，所以这个值我们必须在添加的时候就进行操作保存
    // 维护一个辅助栈,辅助栈栈顶元素始终是 minStack栈 内的最小值
    Deque<Integer> helpStack;

    public MinStack() {
        minStack = new LinkedList<>();
        helpStack = new LinkedList<>();
    }

    public void push(int val) {
        // 添加
        minStack.push(val);
        // 更新 helpStack 栈顶元素（最小值）
        // 如果这个值比栈顶元素小
        if (helpStack.isEmpty() || val < helpStack.peek()) {
            helpStack.push(val);
            // 值更大，将栈顶元素再加一次，始终保证两个栈的元素相等
        } else helpStack.push(helpStack.peek());
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
