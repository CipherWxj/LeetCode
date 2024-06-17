/**
 * @author: Wxj
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>输入描述:
 * intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <p>输出描述:
 * [[1,6],[8,10],[15,18]]
 */
package com.company.brush.array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static int[][] solution(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;

        // 按左区间从大到小排序
        // 注意这个匿名内部类的写法
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        // 初始化 已合并区间 的 左边界和右边界
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 后一区间的左边界 和 已合并区间的右边界比较
            // 有重复区域
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else { // 无重复区域
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        // 最后一个不要忘了添加
        list.add(new int[]{left, right});
        // List.toArray 方法的用法
        return list.toArray(new int[list.size()][]);
    }
}
