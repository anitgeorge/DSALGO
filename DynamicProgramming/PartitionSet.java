class PartitionSet {

  public int canPartition(int[] nums) {

           if(nums == null || nums.length == 0) return -1;

           return canPartUtil(nums, 0, 0, 0);
  }

  private int canPartUtil(int[] nums, int index, int sum1, int sum2){
      return index == nums.length ? Math.abs(sum1 - sum2) : Math.min(canPartUtil(nums, index + 1, sum1 + nums[index], sum2),
                                                            canPartUtil(nums, index + 1, sum1, sum2 + nums[index]));
  }
}


class PartitionSetTDM{

    public int canPartition(int[] nums){

       if(nums == null || nums.length == 0) return -1;
       int sum = 0;
       for(int num : nums) sum += num;

       Integer[][] dp = new Integer[nums.length][sum + 1];
       return canPartUtil(dp, nums, 0, 0, 0);
    }

    private int canPartUtil(Integer[][] dp, int[] nums, int index, int sum1, int sum2){

      if(index == nums.length) return Math.abs(sum1 - sum2);

      if(dp[index][sum1] == null){

         dp[index][sum1] = Math.min(canPartUtil(dp, nums, index + 1, sum1 + nums[index], sum2),
                                    canPartUtil(dp, nums, index + 1, sum1, sum2 + nums[index])
                           );
      }

      return dp[index][sum1];
    }
}

class PartitionSetBUDP{

    public int canPartition(int[] nums){

       if(nums == null || nums.length == 0) return -1;

       int sum = 0, len = nums.length, sum1 = 0, sum2 = 0;
       for(int num : nums) sum += num;
       boolean[][] dp = new boolean[len][sum/2 + 1];
       for(int i = 0; i < len; i++) dp[i][0] = true;
       for(int j = 1; j <= sum/2; j++) dp[0][j] = (j == nums[0] ? true : false);

       for(int i = 1; i < len; i++){

           for(int j = 1; j <= sum/2; j++){

               if(dp[i-1][j]){

                   dp[i][j] = true;
               } else if(j >= nums[i]){

                   dp[i][j] = dp[i - 1][j - nums[i]];
               }
           }
       }

       for(int i = sum/2; i >= 0; i--){

           if(dp[len - 1][i] == true){

               sum1 = i; break;
           }
       }

       sum2 = sum - sum1;

       return Math.abs(sum1 - sum2);
    }
}
