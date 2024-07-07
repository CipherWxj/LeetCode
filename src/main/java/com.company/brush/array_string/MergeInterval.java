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
        // 重写比较器，根据区间左端点从小到大排序
        // 排序之后，只有考虑区间的右边界，左边界不用考虑
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // list便于操作
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // 遍历到的区间的左右边界
            int left = intervals[i][0], right = intervals[i][1];
            // 当前区间与已经合并的区间不重合，将当前区间加入结果中
            // 兼容第一个区间
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else { // 当前区间与已经遍历的区间重合，合并区间，更新右边界，左边界已经排序过了，一定小于等于已经合并的区间
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
