class EqualSum{

      public boolean canPartition(int[] nums){

	      if(nums == null || nums.length == 0) return false;

	      int sum = 0;
	      for(int num : nums) sum += num;

	      return sum % 2 == 0 ? canPart(nums, sum/2, o) : false;
      }

      private boolean canPart(int[] nums, int sum, int index){

             if(sum == 0) return true;

	     if(nums.length == 0 || index >= nums.length) return false;

	     if(nums[index] <= sum){

		     if(canPart(nums, sum - nums[index], index + 1))
			     return true;
	     }

	     return canPart(nums, sum, index + 1);
      }
}

class EqualSumTD(int[] nums){

    public boolean canPartition(int[] nums){
	if(nums == null || nums.length == 0) return false;

	int sum = 0;
        for(int num : nums) sum += num;

	if(sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];

	return canPart(dp, nums, sum, 0);
   }

   private boolean canPart(Boolean[][] dp, int[] nums, int sum, int index){

	   if(sum == 0) return true;

	   if(nums.length <=0 || nums.length <= index) return false;

	   if(dp[index][sum] == null){

		   if(nums[index] <= sum)
			   if(canPart(dp, nums, sum - nums[index], index + 1)
					   dp[index][sum]  = true;

		   dp[index][sum] = canPart(dp, num, sum, index + 1);
           }

	   return dp[index][sum];

   }
}

class EqualSumBUDP(int[] nums){

    if(nums == null || nums.length == 0) return false;

    int len  = nums.length, sum = 0;
    for(int num : nums) sum += num;

    if(sum % 2 != 0) return 0;

    sum /= 2;

    boolean[][] dp = new boolean[len][sum + 1];
    for(int i = 0; i < len; i++)
       dp[i][0] = true;
    for(int j = 1; i <= sum; j++)
       dp[0][j] = (nums[0] == j ? true : false);

    for(int i = 1; i < len; i++){

        for(int j = 1; j <= sum; j++){

            if(dp[i-1][j]){
               dp[i][j] = dp[i-1][j];
            } else if( sum >= nums[i]){
               dp[i][j] = dp[i-1][sum - nums[i]];
            }
        }
    }

    return dp[len-1][sum];

}

