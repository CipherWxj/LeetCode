package com.company.DataStructure.Stack;

import java.util.*;
import java.util.Stack;

public class PostfixExpressionCaculator {
    /**
     * 后缀表达式
     * 从左往右扫描，遇到数字直接入栈；
     * 遇到运算符时，栈顶的两个数字出栈，与运算符进行运算；
     * 结果再入栈，重复。
     */
    public static void main(String[] args) {

        Stack<String> numStack = new Stack<String>(); // 数字栈
        System.out.println("请输入一个后缀表达式，字符间用空格隔开：");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] attr = expression.split(" "); // 空格分隔字符串
        List<String> list = new ArrayList<String>(Arrays.asList(attr));

        // 遍历 list表达式
        for (String item : list) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                numStack.push(item);
            } else {
                // pop出两个数，并运算，再入栈
                int num1 = Integer.parseInt(numStack.pop());
                int num2 = Integer.parseInt(numStack.pop());
                int res = caculator(num1, num2, item);

                //把 res 入栈
                numStack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        System.out.printf("表达式 %s = %d", expression, Integer.parseInt(numStack.pop()));
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


