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
package com.company.brush.dynamicprogramming;

import java.util.HashMap;

public class LongestConsecutive {
    public static int solution(int[] nums) {
        // 用 HashMap 来维护动态数组，key作为记录起始或结束的数，value记录连续长度
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int num : nums
        ) {
            // 遍历数组，如果 map 已经存在这个数num了，跳过
            // 如果 map 中不存在这个数num，则将num添加进map，并更新连续子序列的长度
            if(map.isEmpty() || !map.containsKey(num)){
                // 更新的长度、num左侧连续数的长度、num右侧连续数的长度
                int len = 1, leftLen = 0, rightLen = 0;
                // 判断左侧是否连续，只需要看 num-1 是否在map.key中
                if(map.containsKey(num - 1)){
                    // 取出左侧连续子序列长度
                    leftLen = map.get(num - 1);
                }
                // 判断右侧是否连续，只需要看 num+1 是否在map.key中
                if(map.containsKey(num + 1)){
                    // 取出右侧连续子序列长度
                    rightLen = map.get(num + 1);
                }
                // 更新的长度 = 左侧 + 1（num）+ 右侧
                len = leftLen + 1 + rightLen;
                // 将 num 放入map中，方便后续去重，不放入的话后面再有 位置 会错乱！！！
                map.put(num, len);
                // 更新边界，边界中间都是连续的，即[num - leftLen, num + rightLen]都在map.key中
                map.put(num - leftLen, len);
                map.put(num + rightLen, len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(solution(nums));
    }
}
