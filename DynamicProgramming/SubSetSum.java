class SubsetSum {

  static boolean canPartition(int[] nums, int sum) {
    if(nums == null || nums.length == 0)
    return false;
    int len = nums.length;
    boolean[][] dp = new boolean[len][sum + 1];

    for(int i = 0; i < len; i++)
      dp[i][0] = true;
    for(int j = 1; j <= sum; j++)
      dp[0][j] = (j == nums[0] ? true: false);

    for(int i = 1; i < len; i++){

       for(int j = 1; j <= sum; j++){

           if(dp[i-1][j]){

               dp[i][j] = dp[i-1][j];
           } else if(j >= nums[i]){

               dp[i][j] = dp[i-1][j - nums[i]];
           }
       }
    }

    return dp[len - 1][sum];
  }
}
