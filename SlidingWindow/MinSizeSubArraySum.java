class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    if(arr == null || arr.length == 0)
    return -1;
    int minWindow = Integer.MAX_VALUE;
    int start = 0, end = 0;
    int sum = 0;
    for(end = 0; end < arr.length; end++){
         if(arr[end] >=S) return 1;
         sum += arr[end];
         while(sum >= S){
              minWindow = Math.min(minWindow, end - start + 1);
              sum -=arr[start++];
         }
    }
 
    return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
  }
}

