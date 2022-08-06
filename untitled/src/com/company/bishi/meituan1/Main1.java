/**
 * 小美开的西点屋举办一周年活动，她准备制作一批礼盒作为对消费者的回馈，每个礼盒中都有三枚西点屋的招牌点心。
 * 西点屋共有A和B两种招牌点心，为了让消费者都能品尝到两种点心，因此每个礼盒中都要包含至少一枚A点心和一枚B点心。
 * 现在小美的西点屋内共有x枚A点心和y枚B点心，请问小美最多可以制作多少个礼盒。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入第一行包含一个正整数T，表示数据组数。(1<=T<=10000)
 * <p>
 * 然后有T行，每行包含两个整数x和y，空格隔开，表示有x枚A点心和y枚B点心。(1<=x,y<=10^9)
 * <p>
 * 输出描述
 * 输出包含T行，每行一个整数，表示最多可以制作的礼盒数量。
 */
package com.company.bishi.meituan1;

import java.util.Scanner;

public class Main1 {
    public static int solution(int x, int y) {

        //假设能做 ans 盒，那么 ans <=A, ans<=B 且 3*ans<=A+B
        int ans = (x + y) / 3;
        ans = Math.min(ans, x);
        ans = Math.min(ans, y);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] xA = new int[t];
        int[] yB = new int[t];
        for (int i = 0; i < t; i++) {
            xA[i] = sc.nextInt();
            yB[i] = sc.nextInt();
            System.out.println(solution(xA[i], yB[i]));
        }
    }
}
