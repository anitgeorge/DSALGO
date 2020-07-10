class TargetSum{

     public int findTargetSum(int[] nums, int sum){

         if(nums == null || nums.length == 0) return 0;
         int totalSum = 0;
         for(int num : nums) totalSum += num;

         if(totalSum < sum || (totalSum + sum) % 2 != 0) return 0;
         int netSum = (totalSum + sum)/2;
         int[][] dp = new int[nums.length][netSum + 1];

         for(int i = 0; i < nums.length; i++) dp[i][0] = 1;
         for(int j = 1; j <= netSum; j++) dp[0][j] = (j == nums[0] ? 1 : 0);

         for(int i = 1; i < nums.length; i++{

            for(int j = 1; j <= netSum; j++{

                dp[i][j] = dp[i-1][j];

                if(j >= nums[i]){

                    dp[i][j] += dp[i-1][j - nums[i]];
                }
            }
         }

         return dp[nums.length - 1][netSum];
     }
}
