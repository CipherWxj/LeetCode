package com.company.DataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixExpressionCaculator {
    /**
     * 中缀表达式
     * 从左往右遍历，数字直接入数字栈；
     * 遇到运算符将其与运算符栈栈顶的运算符比较优先级，优先级更高，则入栈；
     * 优先级更低，取出运算符栈栈顶运算符和数字栈栈顶和次栈顶的数字进行运算，然后把结果压入数字栈中；
     * 循环操作，遍历扫描表达式；
     * 最后数字、运算符依次出栈运算。
     */
    public static void main(String[] args) {

        Stack<Object> numStack = new Stack<Object>(); // 数字栈
        Stack<Character> operatorStack = new Stack<Character>(); // 运算符栈
        System.out.println("请输入一个中缀表达式，字符间用空格隔开：");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] attr = expression.split(" "); // 空格分隔字符串
        int len = attr.length;
        boolean flag = false;

        // 中缀表达式扫描
        for (String item : attr) {
            if (!(item.equals("-") || item.equals("+") || item.equals("/") || item.equals("*"))) {
                numStack.push(Integer.parseInt(item)); // 数字直接入栈
            } else {
                if (!operatorStack.empty()) {
                    if (priority(item.charAt(0)) <= priority(operatorStack.peek().toString().charAt(0))) {
                        int num1 = (Integer) numStack.pop();
                        int num2 = (Integer) numStack.pop();
                        char operator = operatorStack.pop();
                        int res = caculator(num1, num2, String.valueOf(operator));
                        // 把运算的结果入数栈
                        numStack.push(res);
                        // 然后将当前的操作符入运算符栈
                    }
                }
                // 如果 运算符栈为空 或 当前的操作符的优先级大于栈中的操作符， 就直接入运算符栈
                operatorStack.push(item.charAt(0));
            }
        }

        // 当表达式扫描完毕，就顺序的从 数栈和运算符栈中pop出相应的数和符号，并运行
        while (true) {
            // 如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operatorStack.isEmpty()) {
                break;
            }
            int num1 = (Integer) numStack.pop();
            int num2 = (Integer) numStack.pop();
            char operator = operatorStack.pop();
            int res = caculator(num1, num2, String.valueOf(operator));
            // 把运算的结果入数栈
            numStack.push(res);//入栈
        }
        // 将数栈的最后数，pop出，就是结果
        int ans = (Integer) numStack.pop();
        System.out.printf("表达式 %s = %d", expression, ans);
    }

    public static int priority(int operator) {
        /**
         运算符优先级判断
         */
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
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
                return b / a;
            case "+":
                return a + b;
            case "-":
                return b - a;
        }
        return 0;
    }
}
