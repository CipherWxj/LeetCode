/**
 * @author: Wxj
 * 739. 每日温度
 * 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>输入描述:
 * temperatures = [73,74,75,71,69,72,76,73]
 * <p>输出描述:
 * [1,1,4,2,1,1,0,0]
 */
package com.company.brush.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] solution(int[] temperatures) {
        int n = temperatures.length;
        //if(n == 1) return new int[]{0}; // 这里可以不用考虑，java数组初始化默认元素全为 0
        int[] answer = new int[n];
        // 维护一个单调栈，存储 temperatures 的下标
        // 使得 栈底到栈顶 的 下标对应的元素 递减
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 不为空 且 当前元素对应的温度 大于 栈顶元素对应的温度
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 出栈
                int j = stack.poll();
                // 计算栈顶元素位置的结果
                answer[j] = i - j;
            }
            // 为空 或 当前元素对应的温度 小于 栈顶元素对应的温度，入栈
            stack.push(i);
        }
        return answer;
    }
}
