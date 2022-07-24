/**
 * @author: Wxj
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>输入描述:
 * numCourses = 2, prerequisites = [[1,0]]
 * <p>输出描述:
 * true
 */
package com.company.brush.topologicalSorting;

import java.util.LinkedList;
import java.util.Queue;

public class CanFinishCourses {
    public boolean solution(int numCourses, int[][] prerequisites) {
        // 记录 节点 i 的 入度（有多少条有向边指向该节点）数
        int[] numEdge = new int[numCourses];
        // 遍历一次图，初始化所有节点的 入度数
        for (int[] prerequisite : prerequisites) {
            numEdge[prerequisite[1]]++;
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
        // bfs搜索
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            // 搜索 该节点指向的全部下一节点，并将它们的 入度数-1
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == u) {
                    numEdge[prerequisite[1]]--;
                    // 入度数为 0，入栈
                    if (numEdge[prerequisite[1]] == 0) {
                        queue.offer(prerequisite[1]);
                    }
                }
            }
        }
        // 如果所有节点遍历一遍，说明拓扑序列存在，返回true
        // 否则，说明存在环，返回false
        return visited == numCourses;
    }
}
