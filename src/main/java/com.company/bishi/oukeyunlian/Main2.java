package com.company.bishi.oukeyunlian;

import java.util.Arrays;


public class Main2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // write code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int[] a = new int[n1 + n2];
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            int num1 = nums1[i1], num2 = nums2[i2];
            if (num1 == num2) {
                if (i == 0 || num1 != a[i - 1]) {
                    a[i] = num1;
                    i++;
                }
                i1++;
                i2++;
            } else if (num1 < num2) {
                i1++;
            } else {
                i2++;
            }
        }
        return Arrays.copyOfRange(a, 0, i);
    }
}
