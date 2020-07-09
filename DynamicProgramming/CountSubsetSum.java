class CountSubsetSum{

     public int countSubsets(int[] nums, int sum){

          if(nums == null || nums.length == 0) return -1;

          countSubsetsRecursive(nums, sum, 0);
     }

     private int countSubsetsRecursive(int[] nums, int sum, int index){

          if(sum == 0) return 1;
          if(nums.length == 0 || index >= nums.length) return 0;

          int sum1 = 0;
          if(nums[index] < sum){

               sum1 = countSubsetsRecursive(nums, sum - nums[index], index + 1);
          }

          sum2 = countSubsetsRecursive(nums, sum, index + 1);

          return sum1 + sum2;
     }
}

class CountSubsetSumTDM{

     public int countSubsets(int[] nums, int sum){

          Integer[][] dp = new Integer[nums.length][sum + 1];
          return countSubsetsRecursive(dp, nums, sum, 0);
     }

     private int countSubsetsRecursive(Integer[][] dp, int[] nums, int sum, int index){

        if(sum == 0) return 1;
        if(nums.length == 0 || nums.length <= index) return 0;

        if(dp[index][sum] == null){

            int sum1 = 0;
            if(nums[index] <= sum) sum1 = countSubsetsRecursive(dp, nums, sum - nums[index], index + 1);
            int sum2 = countSubsetsRecursive(dp, nums, sum, index + 1);

            dp[index][sum] = sum1 + sum2;
        }
        return dp[index][sum];
     }
}

class CountSubsetSumTDM{

     public int countSubsets(int[] nums, int sum){

        if(nums == null || nums.length == 0) return -1;
        int[][] dp = new int[nums.length][sum + 1];
        for(int i = 0; i < nums.length; i++) dp[i][0] = 1;
        for(int j = 1; j <= sum; j++) dp[0][j] = (j == nums[0] ? 1 : 0);

        for(int i = 1; i < nums.length; i++){

             for(int j = 1; j <= sum; j++){

                 dp[i][j] = dp[i-1][j] + (j >= nums[i] ? dp[i - 1][j - nums[i]]: 0);
             }
        }
        return dp[nums.length - 1][sum];       
     }
}
