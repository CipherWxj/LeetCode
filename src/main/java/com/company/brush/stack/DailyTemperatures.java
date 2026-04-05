package com.company.brush.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: wangxinjian
 * 739. 每日温度
 * 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>输入描述:
 * temperatures = [73,74,75,71,69,72,76,73]
 * <p>输出描述:
 * [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // 初始化单调递减栈，栈里存数组位置索引，栈内元素对应的温度栈底到栈顶递减
        Deque<Integer> decStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 如果栈不为空且当前温度大于栈顶索引对应的温度，说明找到了栈顶索引的下一个更高温度，直到栈为空或当前温度小于等于栈顶索引对应的温度
            while (!decStack.isEmpty() && temperatures[decStack.peek()] < temperatures[i]) {
                // 栈顶索引出栈
                int j = decStack.pop();
                // 计算栈顶索引下一个更高温度出现在几天后
                answer[j] = i - j;
            }
            // 当前索引入栈
            decStack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

    }
}
