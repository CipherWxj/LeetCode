/**
 * @author: Wxj
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>输入描述:
 * board = [["A","B","C","E"],
 *          ["S","F","C","S"],
 *          ["A","D","E","E"]],
 * word = "ABCCED"
 * <p>输出描述:
 * true
 */
package com.company.brush.backtracking;

public class ExistWord {
    public boolean solution(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        // 维护一个相同大小的数组，标记该位置是否被访问
        boolean[][] visited = new boolean[m][n];
        // 从不同位置开始搜索
        for(int i = 0; i < m; i++) {
            for(int j =0; j < n; j++) {
                // 全部搜索到，返回 true
                if(backTrack(i, j, board, visited, word, 0)) return true;
            }
        }
        return false;
    }

    // 回溯
    public boolean backTrack(int i, int j, char[][] board, boolean[][] visited, String word, int index) {
        // 字符不同，直接返回 false
        if(board[i][j] != word.charAt(index)) return false;
        // word 整个遍历完，返回 true
        if(index == word.length() - 1) return true;
        // 标记遍历到的位置
        visited[i][j] = true;
        // 记录接下来向四周递归的结果
        boolean catched = false;
        // 四周的位置，方便简化代码（左、上、右、下）
        int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int[] dir : direction) {
            // 接下来递归的坐标
            int x = i + dir[0], y = j + dir[1];
            // 不能越界，且该位置未被访问
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                // 接下来的字符是否都能搜索到
                if(backTrack(x, y, board, visited, word, index + 1)) {
                    catched = true;
                }
            }
        }
        // 回溯操作，遍历过的位置重置
        visited[i][j] = false;
        return catched;
    }
}
