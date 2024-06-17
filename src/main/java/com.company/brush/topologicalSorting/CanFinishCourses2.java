/**
 * @author: Wxj
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，
 * 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>输入描述:
 * numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * <p>输出描述:
 * [0,2,1,3] 或 [0,1,2,3]
 */
package com.company.brush.topologicalSorting;

import java.util.*;

public class CanFinishCourses2 {
    public int[] solution(int numCourses, int[][] prerequisites) {
        // 记录 节点 i 的 入度（有多少条有向边指向该节点）数
        int[] numEdge = new int[numCourses];
        // 遍历一次图，初始化所有节点的 入度数
        for (int[] prerequisite : prerequisites) {
            numEdge[prerequisite[0]]++;
        }

        // 初始化一个队列（栈也行），将所有 入度数为0 的节点入栈
        // 没有说明有 环，就不执行下面的 while
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numEdge[i] == 0) {
                queue.offer(i);
            }
        }
        // 走过的节点数
        int visited = 0;
        // 记录结果
        int[] res = new int[numCourses];
        // bfs搜索
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            res[visited - 1] = u; // 注意索引
            // 搜索 该节点指向的全部下一节点，并将它们的 入度数-1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == u) {
                    numEdge[prerequisite[0]]--;
                    // 入度数为 0，入栈
                    if (numEdge[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        // 如果所有节点遍历一遍，说明拓扑序列存在，返回 res
        // 否则，说明存在环，返回 空数组
        return visited == numCourses ? res : new int[0];
    }
}
