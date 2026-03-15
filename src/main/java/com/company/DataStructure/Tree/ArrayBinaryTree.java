package com.company.DataStructure.Tree;

public class ArrayBinaryTree {

    private int[] arr; // 存储数据结点的数组

    // 构造函数
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    // 编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        /**
         * @param index 数组的下标
         */
        // 如果数组为空，或者 arr.length = 0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1 );
        }
        // 向右递归遍历
        if((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // 创建一个 ArrBinaryTree
        ArrayBinaryTree arrBinaryTree = new ArrayBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }
}
