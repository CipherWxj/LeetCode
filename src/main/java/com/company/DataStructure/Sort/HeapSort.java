package com.company.DataStructure.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    /**
     * 堆排序
     */
    public static void main(String[] args) {
        System.out.println("请输入随机数组，用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arrs = s.split(",");
        int[] arr = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            arr[i] = Integer.parseInt(arrs[i]);
        }
        // 测试堆排序
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {

        // 1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆(升)或小顶堆（降）
        // 从最后一个非叶子节点开始 (arr.length / 2 - 1)
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //adjustMaxHeap(arr, i, arr.length);
            adjustMinHeap(arr,i, arr.length);
        }
        /*
         * 2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
         * 3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //adjustMaxHeap(arr, 0, j);
            adjustMinHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    // 将一个数组(二叉树), 调整成一个大顶堆
    // 迭代
    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9, 6, 8, 5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustMaxHeap(int[] arr, int i, int length) {

        int temp = arr[i]; // 先取出当前元素的值，父节点
        // 开始调整
        // k=i*2+1，是 i节点 的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { //说明左子节点的值小于右子节点的值
                k++; // k 指向右子节点
            }
            if (arr[k] > temp) { // 如果子节点大于父节点
                arr[i] = arr[k]; // 把较大的值赋给当前节点
                i = k; // !!! i 指向 k,继续向下调整
            } else {
                break;
            }
        }
        // 当for 循环结束后，我们已经将以 i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp; // 将temp值放到调整后的位置
    }

    // 将一个数组(二叉树), 调整成一个小顶堆
    // 递归
    public static void adjustMinHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1, right = 2 * i + 2, largest = i;
        // 根节点>左子节点
        if (left < length && arr[largest] > arr[left]) {
            largest = left;
        }
        // 根节点>右子节点
        if (right < length && arr[largest] > arr[right]) {
            largest = right;
        }
        // 调整
        if (largest != i) {
            // 交换
            int temp;
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // 向子树递归调整
            adjustMinHeap(arr, largest, length);
        }
    }
}
