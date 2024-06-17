package com.company.DataStructure.Recursion;

public class Queen8 {
    /**
     * 八皇后问题   任意两个皇后不能位于同一行、同一列和同一45°斜线上！
     */
    int max = 8; // 皇后数
    // 定义数组array, 保存皇后放置的位置
    // array的索引作为行，所存数字为列，不必创建二维数组
    int[] array = new int[max];
    static int count = 0; // 正解计数器
    static int judgeCount = 0; // 判断次数

    public static void main(String[] args) {
        //测试一把 ， 8皇后是否正确
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法\n", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w

    }


    //编写一个方法，放置第n个皇后
    //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if (n == max) {  // n=8，8个皇后都放好了
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) { // 不冲突
                // 接着放n+1个皇后,即开始递归
                check(n + 1);
            }
            // 如果冲突，就继续执行 array[n] = i; 当前基础上后移一个位置 i++
        }
    }

    private boolean judge(int n) {
        /**
         * 判断是否可以放置在该位置
         */
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // array[i] == array[n]  判断 第n个皇后是否和前面的n-1个皇后在同一列
            // Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断第n个皇后是否和第i皇后是否在同一斜线（类比三角函数正切）
            // 没有必要判断是否在同一行, 因为 n 人为每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true; // 不冲突
    }


    private void print() {
        /**
         * 皇后位置输出显示
         */
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
