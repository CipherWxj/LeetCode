/**
 * @author: Wxj
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>输入描述:
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * <p>输出描述:
 * [null,null,3,-1]
 */
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> memoryStack; // 实际的元素存储栈
    Deque<Integer> assistStack; // 辅助操作栈

    public CQueue() {
        memoryStack = new LinkedList<>();
        assistStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        memoryStack.push(value); // 直接在末尾插入
    }

    public int deleteHead() {
        if(memoryStack.isEmpty()) return -1; // 为空
        // 将所有元素 push 进辅助栈，尾部在栈顶
        while(!memoryStack.isEmpty()){
            assistStack.push(memoryStack.poll());
        }
        // 取出栈顶元素
        int tail = assistStack.poll();
        // 剩余元素再压入存储栈
        while(!assistStack.isEmpty()){
            memoryStack.push(assistStack.poll());
        }
        // 返回取出的元素
        return tail;
    }
}
