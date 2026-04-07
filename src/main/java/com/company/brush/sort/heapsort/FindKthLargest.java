package com.company.brush.sort.heapsort;

/**
 * @author: wangxinjian
 * 215. 数组中的第 K 个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>输入描述:
 * [3,2,1,5,6,4] 和 k = 2
 * <p>输出描述:
 * 5
 */
public class FindKthLargest {
    public static int solution(int[] nums, int k) {
        // 假设原数组的元素依次从根节点开始构建完全二叉树，则最后一个非叶子节点的索引为 n/2 - 1
        // 从最后一个非叶子节点开始调整二叉树，构造大根堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 调整堆
            adjustMaxHeap(nums, i, nums.length);
        }
        // 找出第 k 个最大元素
        for (int j = nums.length - 1; j > nums.length - k; j--) {
            // 交换根节点（最大值）和最后一个节点
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            // 最后一个节点剔除，重新调整堆
            adjustMaxHeap(nums, 0, j);
        }
        return nums[0];
    }

    public static void adjustMaxHeap(int[] arr, int i, int length) {
        // 获取左子节点和右子节点索引
        int leftChild = 2 * i + 1, rightChild = 2 * i + 2;
        // 假设根节点为最大值
        int largest = i;
        // 比较左子节点和右子节点，更新最大值索引
        if (leftChild < length && arr[leftChild] > arr[largest]) largest = leftChild;
        if (rightChild < length && arr[rightChild] > arr[largest]) largest = rightChild;
        if (largest != i) {
            // 交换原数组元素
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // 向子树递归调整
            adjustMaxHeap(arr, largest, length);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println((solution(nums, k)));
    }
}
