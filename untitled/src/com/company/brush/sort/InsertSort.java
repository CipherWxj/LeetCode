public class InsertSort{
  public int[] solution(int[] nums){
    return insertSort(nums);
  }
  
  // 插入排序
  // 假定前 x 个元素已排序，取出第 x+1 个元素，从前往后扫描
  // 如果扫描到的元素大于（小于）该元素，则后移，直到前面所有元素都小于（大于）该元素
  // 该位置就是 该元素 的插入位置
  // 时间复杂度 O(n^2)，空间复杂度 O(1)
  public int[] insertSort(int[] nums){
    int insIndex, insValue; 
    // 执行 n-1 次，第一次假设第一个元素已经排序，第二次假设前两个元素已经排序……
    for(int i = 1; i < nums.length; i++){
      insValue = nums[i]; // 待插入的值
      insIndex = i - 1; // 待插入的位置
      // 保证索引存在！！
      while(insIndex >= 0 && nums[insIndex] > insValue){
        nums[insIndex + 1] = nums[insIndex]; // 后移
        insIndex--; // 向前搜索
      }
      nums[insIndex + 1] = insValue; // 插入
    }
  }
}
