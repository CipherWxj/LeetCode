package com.company.DataStructure.Stack;

import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 添加数据到栈(入栈)");
            System.out.println("pop: 从栈取出数据(出栈)");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.listShow();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}


class ArrayStack {
    /**
     * 数组模拟 栈
     */
    private final int maxSize; // 栈的大小
    private final int[] stack; // 数组模拟栈，数据存放在该数组
    private int top = -1;// top：栈顶，初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈————push
    public void push(int value) {
        //先判断栈是否已满
        if (isFull()) {
            System.out.println("栈满，无法加入~");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈————pop
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void listShow() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}