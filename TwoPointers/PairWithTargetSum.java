class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    if(arr == null || arr.length == 0)
    return new int[] { -1, -1 };
    
    int start = 0, end = arr.length -1;

    while(start <= end){
    
        if(arr[start]+arr[end] == targetSum) return new int[]{start, end};
        else if(arr[start]+arr[end] > targetSum) end--;
        else start++;
    }

    return new int[]{-1, -1};
  }
}
