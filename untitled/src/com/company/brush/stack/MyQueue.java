/**
 * @author: Wxj
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>输入描述:
 * root = [1,null,2,3]["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * <p>输出描述:
 * [null, null, null, 1, 1, false]
 */
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    static Deque<Integer> input; // 仅仅在 push 时用作转换元素顺序
    static Deque<Integer> save; // 实际存储元素，栈顶是队列的头部

    // 构造函数
    public MyQueue() {
        input = new LinkedList<>();
        save = new LinkedList<>();
    }

    // 入列
    public void push(int x) {
        // 将 save 中所有元素顺序压入 input，则队列的尾部元素在 input 的栈顶
        while (!save.isEmpty()){
            input.push(save.pop());
        }
        // 末尾添加
        input.push(x);
        // 重新顺序压回 save
        while (!input.isEmpty()) {
            save.push(input.pop());
        }
    }

    // 出列
    public int pop() {
        return save.pop();
    }

    // 获取头部元素
    public int peek() {
        // 防止空指针异常
        if (save.isEmpty()){
            System.out.println("队列为空");
            return 0;
        }
        return save.peek();
    }

    // 为空
    public boolean empty() {
        return save.isEmpty();
    }
}
