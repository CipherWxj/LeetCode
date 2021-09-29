package com.company;

public class MedianOfTwoArrays {

    public static double solution(int[] num1, int[] num2) {
        int n1 = num1.length;
        int n2 = num2.length;
        int n = n1 + n2;
        int[] num = new int[n];

        for (int k = 0; k < n1; k++) {
            num[k] = num1[k];
        }

        for (int k = 0; k < n2; k++) {
            num[k + n1] = num2[k];
        }

        //第一个循环用来遍历数组中的所有数字
        for (int i = 0; i < n; i++) {
            //初始化一个变量，用来记录最小数字的下标。初始默认假设第一个数字就是最小数字
            int minIndex = i;
            //第二个循环，通过比较获取数组中最小的数字的下标。
            for (int j = i + 1; j < n; j++) {
                //如果找到更小的数字，
                if (num[minIndex] >= num[j]) {
                    //将minIndex变量的值修改为新的最小数字的下标。
                    minIndex = j;
                }
            }
            //所有数字一个个比较结束之后，就能确认那个数字最小了。
            //将最小的数字替换到第一个位置，将第一个位置的数字放到最小数字原来的位置，就是一次交换。
            int temp = num[i];
            num[i] = num[minIndex];
            num[minIndex] = temp;
        }


    }
}

