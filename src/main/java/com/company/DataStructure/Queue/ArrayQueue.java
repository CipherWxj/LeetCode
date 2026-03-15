package com.company.DataStructure.Queue;

import java.util.Scanner;

public class ArrayQueue {
    /**
     * 数组模拟队列
     */

    private int maxSize; // 队列的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 创建数组，模拟队列

    // 构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 初始化队列头部，front指向队列头的前一个位置
        rear = -1; // 初始化队列尾部，rear指向队列尾部最后一个元素
    }

    // 判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加元素：从尾部入列
    public void addQueue(int n) {
        // 判断是否已满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++; //rear后移，指向当前添加的元素
        arr[rear] = n;
    }

    // 取出元素：从头部出列
    public int getQueue() {
        // 判断是否为空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("队列为空");
        }
        front++; //fron后移，指向当前取出的元素
        return arr[front];

    }

    // 显示整个队列数据
    public void showQueue() {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public static void main(String[] args) {
        /**
         * 测试
         */
        Scanner scanner = new Scanner(System.in);

        // 创建队列
        System.out.print("请输入队列长度:");
        int arrMaxSize = scanner.nextInt();
        ArrayQueue queue = new ArrayQueue(arrMaxSize);

        char key = ' '; //创建测试输入
        boolean loop = true;

        // 打印输入提示菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 添加元素");
            System.out.println("g(get): 取出元素");
            key = scanner.next().charAt(0);//接受输入
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入元素:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的元素是:%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}