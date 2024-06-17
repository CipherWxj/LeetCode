package com.company.bishi.zijie;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String nu = sc.nextLine();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        System.out.println(solution(n, m, matrix));
    }

    public static int solution(int n, int m, char[][] matrix) {
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, matrix, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean dfs(int i, int j, char[][] matrix, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return false;
        }
        char c = matrix[i][j];
        if (c == 'O') {
            return true;
        }
        visited[i][j] = true;
        if (c == 'U') {
            if (i == 0 || visited[i - 1][j]) return false;
            return dfs(i - 1, j, matrix, visited);
        } else if (c == 'D') {
            if (i == matrix.length - 1 || visited[i + 1][j]) return false;
            return dfs(i + 1, j, matrix, visited);
        } else if (c == 'L') {
            if (j == 0 || visited[i][j - 1]) return false;
            return dfs(i, j - 1, matrix, visited);
        } else if (c == 'R') {
            if (j == matrix[0].length - 1 || visited[i + 1][j]) return false;
            return dfs(i, j + 1, matrix, visited);
        } else {
            return dfs(i - 1, j, matrix, visited) || dfs(i + 1, j, matrix, visited) || dfs(i, j - 1, matrix, visited) ||
                    dfs(i, j + 1, matrix, visited);
        }
    }
}
