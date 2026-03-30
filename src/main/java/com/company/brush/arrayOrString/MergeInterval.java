package com.company.brush.arrayOrString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wangxinjian
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>输入描述:
 * intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <p>输出描述:
 * [[1,6],[8,10],[15,18]]
 */
public class MergeInterval {
    private static int[][] solution(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            // 根据左区间，从小到大排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        // 待合并区间左、右边界，初始化为第一个区间为待合并区间
        int start = intervals[0][0], end = intervals[0][1];
        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的左边界小于等于待合并区间的右边界，说明当前区间与待合并区间重叠
            if (intervals[i][0] <= end) {
                // 更新合并区间的右边界
                end = Math.max(end, intervals[i][1]);
            } else { // 如果当前区间的左边界大于待合并区间的右边界，说明当前区间与待合并区间不重叠
                // 将待合并区间加入结果中
                res.add(new int[]{start, end});
                // 更新待合并区间为当前区间
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 最后一个待合并区间加入结果中
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution(intervals);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

    }
}
