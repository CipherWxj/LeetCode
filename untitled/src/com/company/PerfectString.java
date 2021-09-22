/**
 * 给出一个长度为n的数列，请计算这个数列中长度不超过k的严格递增子序列的个数；
 * 因为答案可能很大，所以请输出答案对2^61-1的模数；
 * 子序列是指从最初序列通过去除某些元素但不破坏余下元素的相对位置(在前或在后)而形成的新序列；
 * 例如：对于数列[1,2,3,4]，[1,3, 4]是它的子序列，但[1,4,3]不是。
 * <p>输入描述:
 * 先在一行中给出两个正整数n,k，含义如题面描述所示；
 * 接下来在新的一行给出n个以空格分隔的正整数a1, a2...an，代表数列里的元素；
 * (1≤n≤10^5，1≤k≤70，ai≤10^9)
 * <p>输出描述:
 * 对于每组数据在一行输出一个整数代表满足条件的子序列个数对2^61-1的模。
 */
package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectString {
    public static int solution(int n, int k, int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); //子序列容器
        List<Integer> sub = new ArrayList<>(); //子序列
        dfs(0, k, n, nums, res, sub); //生成所有子序列
        List<List<Integer>> resSolution = new ArrayList<>(); //最终的子序列链表
        for (int i = 0; i < res.size(); i++) {
            List<Integer> subSolution = res.get(i); //从生成的所有子序列中取出当前子序列
            if (subSolution.size() <= k && subSolution.size() >= 1) { //判断序列长度是否超过k
                int j = 1;
                while (j < subSolution.size()) {
                    if (subSolution.get(j - 1) < subSolution.get(j)) { //判断元素是否严格递增
                        j++;
                    }
                }
                resSolution.add(subSolution); //将满足条件的子序列放入链表
            }
        }
        int count = resSolution.size(); //满足条件的子序列的个数
        count %= (Math.pow(2, 61) - 1); //对2^61-1取模
        return count;
    }

    /*
    生成所有子序列
     */
    public static void dfs(int index, int k, int n, int[] nums, List<List<Integer>> res, List<Integer> sub) {
        res.add(new ArrayList<>(sub)); //向容器中添加子序列
        if (sub.size() == n) {
            return; //判断子序列长度，等于n，退出当前递归
        }
        for (int i = index; i < n; i++) { //从数组第1个元素开始，与后一个比较，较小则添加
            sub.add(nums[i]); //向子序列中添加元素
            dfs(i + 1, k, n, nums, res, sub); //向后循环
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入");
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        solution(n, k, nums);
        System.out.println(solution(n, k, nums));
    }
}