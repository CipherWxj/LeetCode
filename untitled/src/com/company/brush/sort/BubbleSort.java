// 比较相邻元素，根据大小调整先后位置
// 从前往后，依次将最大（小）的元素放到最后
// 时间复杂度 O(n^2)，空间复杂度 O(1)
class BubbleSort{
  public int[] solution(int[] nums){
    return bubbleSort(int[] nums);
  }
  
  public int[] bubbleSort(int[] nums){
    // 进行 n-1 次，第一次找到最大（小）元素放到最后，第二次找到第二大（小）放到倒数第二的位置……
    for(int i = nums.length - 1; i > 0; i--){
      for(int j = 0; j < i; j++){
        if(nums[j] > nums[j + 1]){
          swap(nums, j ,j + 1);
        }
      }
    }
  }
  
  // 交换
  public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
