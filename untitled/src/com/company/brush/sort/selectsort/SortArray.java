package com.company.brush.sort.selectsort;

public class SortArray{
  public int[] solution(int[] nums){
    return selectSort(nums);
  }
  
  // 选择排序
  // 在未排序的序列中找到最小（大）的元素放到序列的开头
  // 继续在未排序的序列中寻找，直到序列只剩末尾元素
  // 时间复杂度 O(n^2)，空间复杂度 O(1)
  public int[] selectSort(int[] nums){
    // 从第一个元素开始，一直到倒数第二个（最后一个不用再找了）
    for(int i = 0; i < nums.length - 1; i++){
      int minIndex = i; // 假设未排序的第一个是最小的位置
      for(int j = i + 1; j < nums.length; j++){
        // 更新最小元素的位置
        if(nums[j] < nums[minIndex]){
          minIndex = j;
        }
      }
      // 放到开头
      swap(nums, i, minIndex);
    }
    return nums;
  }
  
  // 交换
  public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}      
