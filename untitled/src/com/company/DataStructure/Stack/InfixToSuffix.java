package com.company.DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class InfixToSuffix {
    /**
     * 中缀表达式 转 后缀表达式
     * 1）初始化栈 s1 和 运算符栈 s2；
     * 2）从左往右扫描中缀表达式，遇到操作数时，入 s1；
     * 3）遇到运算符时，比较其与符栈 s2 栈顶符号的优先级；
     * 优先级更高，入 s2；优先级更低，s2栈顶符号出栈并入 s1；再重复与s2中下一运算符比较；
     * 4）遇到括号时，“（”入 s2；
     * “）”则依次弹出 s2 栈顶的运算符，并压入 s1，直到遇到 “）”，此时将这一对括号丢弃；
     * 5）遍历完后，将 s2 中运算符依次弹出并压入 s1；
     * 6）s1 中元素依次弹出，逆序。
     */
    public static void main(String[] args) {


        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
        //2. 因为直接对str 进行操作，不方便，因此 先将  "1+((2+3)×4)-5" =》 中缀的表达式对应的List
        //   即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.println("请输入一个中缀表达式：");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]
        System.out.printf("表达式%s=%d\n", expression, suffixCaculator(suffixExpreesionList));
    }

    public static List<String> toInfixExpressionList(String s) {
        /**
         * 将 中缀表达式 转成对应的 List
         */
        List<String> ls = new ArrayList<String>(); // 定义一个List,存放 中缀表达式 的内容
        int i = 0; // 指针，用于遍历 中缀表达式字符串
        StringBuilder str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            // 如果c不是数字，加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) { // '0'[48]-->'9'[57]
                ls.add("" + c);
                i++; // i右移
            } else { // 如果是一个数，需要考虑多位数
                str = new StringBuilder(); //先将str 置成""
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str.append(c);// 拼接
                    i++; // 右移查看下一位是否还是数字
                }
                ls.add(str.toString());
            }
        } while (i < s.length());
        return ls;
    }

    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        /**
         * 将得到的中缀表达式对应的List => 后缀表达式对应的List
         */
        //定义两个栈
        Stack<String> s2 = new Stack<String>(); // 符号栈
        //说明：因为s1 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出,比较麻烦
        //     因此不用 Stack<String> 直接使用 List<String> s1
        //Stack<String> s1 = new Stack<String>(); // 储存中间结果的栈s1
        List<String> s1 = new ArrayList<String>(); // 储存中间结果的List s1

        //遍历ls
        for (String item : ls) {
            // 如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s1.add(item);
            } else if (item.equals("(")) {
                s2.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号“)”，则依次弹出s2栈顶的运算符，并压入s1，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s2.peek().equals("(")) {
                    s1.add(s2.pop());
                }
                s2.pop(); // !!! 将 "(" 弹出 s1栈，消除小括号
            } else {
                // 当item的优先级小于等于s2栈顶运算符, 将s2栈顶的运算符弹出并加入到s1中，
                // 再次与s2中新的栈顶运算符相比较
                while (s2.size() != 0 && getPriority(s2.peek()) >= getPriority(item)) {
                    s1.add(s2.pop());
                }
                //还需要将item压入栈
                s2.push(item);
            }
        }
        // 将s2中剩余的运算符依次弹出并加入s1
        while (s2.size() != 0) {
            s1.add(s2.pop());
        }
        return s1; //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List

    }

    public static int suffixCaculator(List<String> list) {
        /**
         * 后缀表达式计算
         */
        Stack<String> numStack = new Stack<String>(); // 数字栈
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
        return Integer.parseInt(numStack.pop());
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

    public static int getPriority(String operation) {
        /**
         * 运算符优先级判断
         */
        final int ADD = 1;
        final int SUB = 1;
        final int MUL = 2;
        final int DIV = 2;
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            case "(":
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }
}
