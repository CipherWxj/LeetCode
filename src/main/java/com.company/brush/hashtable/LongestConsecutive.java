/**
 * @author: Wxj
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>输入描述:
 * nums = [100,4,200,1,3,2]
 * <p>输出描述:
 * 4
 */
package com.company.brush.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static int solution(int[] nums) {
        // 数组为空的情况优先排除
        if (nums.length == 0) return 0;

        // 初始化一个哈希表，key：连续序列的左边界，value：连续序列的右边界
        Map<Integer, Integer> consecutiveMap = new HashMap<>();
        // 初始化map，假设每个元素都是一个连续序列
        for (int num : nums) {
            consecutiveMap.put(num, num);
        }
        // 最大长度
        int maxLength = 1;
        // 遍历，假设以遍历的数为左边界
        for (int leftNum : nums) {
            // 如果比 leftNum 小1的数存在，那么最长连续序列的左边界必定从 leftNum - 1 开始，为了减少计算复杂度，跳过
            // 如果比 leftNum 小1的数不存在，那么最长连续序列的左边界可以是 leftNum，向右遍历，更新右边界
            // 更新到最后，consecutiveMap中只有 区间最长连续序列 的起始位置key-value会更新，保证了O(n)的时间复杂度
            if (!consecutiveMap.containsKey(leftNum - 1)) {
                int rightNum = consecutiveMap.get(leftNum);
                // 依次向右+1，直到区间连续序列最长
                while (consecutiveMap.containsKey(rightNum + 1)) {
                    rightNum = consecutiveMap.get(rightNum + 1);
                }
                // 更新不更新的没啥实际作用，所以代码可以优化下
                consecutiveMap.put(leftNum, rightNum);
                maxLength = Math.max(maxLength, rightNum - leftNum + 1);
            }
        }
        return maxLength;
    }

    public static int solutionPlus(int[] nums) {
        // 数组为空的情况优先排除
        if (nums.length == 0) return 0;

        // 初始化一个哈希set，key：连续序列的左边界
        Set<Integer> consecutiveSet = new HashSet<>();
        // 去重
        for (int num : nums) {
            consecutiveSet.add(num);
        }
        // 最大长度
        int maxLength = 1;
        // 遍历，假设以遍历的数为左边界
        for (int leftNum : nums) {
            // 如果比 leftNum 小1的数存在，那么最长连续序列的左边界必定从 leftNum - 1 开始，为了减少计算复杂度，跳过
            // 如果比 leftNum 小1的数不存在，那么最长连续序列的左边界可以是 leftNum，向右遍历，更新右边界
            // 更新到最后，consecutiveMap中只有 区间最长连续序列 的起始位置key-value会更新，保证了O(n)的时间复杂度
            if (!consecutiveSet.contains(leftNum - 1)) {
                int rightNum = leftNum;
                // 依次向右+1，直到区间连续序列最长
                while (consecutiveSet.contains(rightNum + 1)) {
                    rightNum = rightNum + 1;
                }
                maxLength = Math.max(maxLength, rightNum - leftNum + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 2, 8, 4, 6, 0, 1};
        // consecutiveMap的结构如下：
        // key：  3, 7, 2, 8, 4, 6, 0, 1
        // value：3, 7, 2, 8, 4, 8, 4, 1
        System.out.println(solution(nums));
    }
}
