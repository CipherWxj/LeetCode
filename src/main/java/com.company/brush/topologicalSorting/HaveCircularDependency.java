/**
 * @author: Wxj
 * 补充：检测循环依赖
 * 现有n个编译项，编号为0 ~ n-1。给定一个二维数组，表示编译项之间有依赖关系。
 * 如[0, 1]表示1依赖于0。
 * 若存在循环依赖则返回空；不存在依赖则返回可行的编译顺序。
 * <p>输入描述:
 * [[0,2],[1,2],[2,3],[2,4]]
 * <p>输出描述:
 * [0,1,2,3,4]
 */
package com.company.brush.topologicalSorting;

import java.util.*;

public class HaveCircularDependency {
    public static int[] solution(int n, int[][] prerequisites) {
        // 有向图
        // list.get(i).get(j) 表示 i 依赖于 j
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        // 入度表
        int[] inDegree = new int[n];

        // 构造有向图和入度表
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[1]]++;
        }

        // 初始将所有 入度为0 的节点入列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[n]; // 结果路径
        int visited = 0; // 记录遍历的节点数

        // BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[visited] = node;
            visited++;
            for (int i = 0; i < n; i++) {
                if (list.get(i).contains(node)) {
                    // 删除依赖节点和有向边（没有必要）
                    // 只需要控制 入度数
                    for(int j = 0; j < list.get(i).size(); j++) {
                        // 注意 list.remove() 的坑！！！
                        if(list.get(i).get(j) == node) {
                            list.get(i).remove(j);
                            j--;
                        }
                    }
                    inDegree[i]--;
                    // 入度为0，入列
                    if (inDegree[i] == 0) { // 等价于list.get(i).isEmpty()
                        queue.offer(i);
                    }
                }
            }
        }
        // 遍历完所有节点，返回 路径
        // 没有遍历完所有节点，说明存在 环（循环依赖）
        return visited == n ? res : new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[][]{{0,2},{1,2},{2,3},{2,4}})));
    }
}
