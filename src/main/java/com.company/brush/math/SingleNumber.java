/**
 * @author: Wxj
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>输入描述:
 * [4,1,2,1,2]
 * <p>输出描述:
 * 4
 */
package com.company.brush.math;

public class SingleNumber {
    // 异或运算有以下三个性质:
    // 任何数和 0 做异或运算，结果仍然是原来的数
    // 任何数和其自身做异或运算，结果是 0
    // 异或运算满足交换律和结合律
    public int solution(int[] nums){
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
