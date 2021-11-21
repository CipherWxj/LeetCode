package com.company.DataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixExpressionCaculator {
    /**
     * 前缀表达式
     * 首先需要从右向左遍历，遇到数字就入栈
     * 遇到符号把栈顶的前两个数字出栈；
     * 然后把结果压入栈中；
     * 循环操作。
     */
    public static void main(String[] args) {

        Stack<Object> numStack = new Stack<Object>(); // 数字栈
        System.out.println("请输入一个前缀表达式，字符间用空格隔开：");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] attr = expression.split(" "); // 空格分隔字符串
        int len = attr.length;
        int charsNum = 0; // 用于记录符号数
        int numsNum = 0; // 用于记录数字的个数

        // 前缀表达式计算
        for (int i = len - 1; i >= 0; i--) {
            if (!(attr[i].equals("-") || attr[i].equals("+") || attr[i].equals("/") || attr[i].equals("*"))) {
                numStack.push(Integer.parseInt(attr[i])); // 数字入栈
                numsNum++;
            } else {
                int a = (Integer) numStack.pop();// 栈顶出栈
                int b = (Integer) numStack.pop();// 次栈顶出栈
                charsNum++;
                int result = caculator(a, b, attr[i]); // 调用函数计算结果值
                numStack.push(result); //结果进栈
            }
        }

        if (!(numsNum - 1 == charsNum) || numStack.empty()) { //没有进入for循环，或者符号不够，或者栈为空
            System.out.println("ERROR!");
        } else {
            int ans = (Integer) numStack.pop();
            System.out.printf("表达式 %s = %d", expression, ans);
        }
    }

    public static int caculator(int a, int b, String s) {
        /**
         * 计算！  注意减法、乘法两数前后顺序
         */
        switch (s) {
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new RuntimeException("分母不能为0！");
                }
                return a / b;
            case "+":
                return a + b;
            case "-":
                return a - b;
        }
        return 0;
    }
}
