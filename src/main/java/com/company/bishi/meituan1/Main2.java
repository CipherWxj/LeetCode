/**
 * 小美有n块魔法石，每块魔法石都有正反两面，每一面上都刻有一个魔法阵，初始状态下，n块魔法石都是正面向上。
 * 这n块魔法石的能量刚好可以构建一个大型魔法阵，但是需要至少一半的魔法石向上的一面铭刻的阵法相同才能触发大型魔法阵的效果。
 * 小美希望翻转最少数量的魔法石，使得这个大型魔法阵被触发，请问她最少需要翻转多少块魔法石。
 * 输入描述：
 * 输入第一行包含一个正整数n，表示魔法石的数量。(1<=n<=100000)
 * 输入第二行包含n个正整数，表示n块魔法石正面铭刻的魔法阵种类，由于魔法书上记载的魔法阵数量太多，所以魔法阵编号可能是从1到10^9中的任何一个正整数。
 * 输入第三行包含n个正整数，表示n块魔法石反面铭刻的魔法阵种类，魔法阵编号同样在1到10^9之间。
 * 数字间两两有空格隔开
 * 输出描述：
 * 输出仅包含一个整数，如果有解则输出最少翻转的魔法石数量，如果无解则输出-1。
 */
package com.company.bishi.meituan1;

import java.util.*;

public class Main2 {
    public static int solution(int n, int[] front, int[] back) {

        HashMap<Integer, Integer> allMap = new HashMap<>();
        HashMap<Integer, Integer> upMap = new HashMap<>();
        //先统计个数
        for (int i = 0; i < n; i++) {
            //两面相同统计一次
            allMap.put(front[i], allMap.getOrDefault(front[i], 0) + 1);
            if (front[i] != back[i]) {
                allMap.put(back[i], allMap.getOrDefault(back[i], 0) + 1);
            }
            upMap.put(front[i], upMap.getOrDefault(front[i], 0) + 1);
        }

        int target = n % 2 == 0 ? n / 2 : n / 2 + 1; // 考虑奇数和偶数
        int ans = n + 1; // 初始值为不可能的大值
        for (Integer key : allMap.keySet()) {
            // 判断是否满足触发大型魔法阵的效果
            if (allMap.get(key) >= target) {
                // 判断是否需要翻转
                // 需要的话更新最小值
                ans = Math.min(ans, upMap.getOrDefault(key, 0) >= target ? 0 : target - upMap.getOrDefault(key, 0));
            }
        }
        return ans == n + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] front = new int[n];
        for (int i = 0; i < n; i++) {
            front[i] = sc.nextInt();
        }
        int[] back = new int[n];
        for (int i = 0; i < n; i++) {
            back[i] = sc.nextInt();
        }
        System.out.println(solution(n, front, back));
    }
}
