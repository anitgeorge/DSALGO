class Knapsack {

  static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if(profits == null || profits.length == 0
       || weights == null || weights.length == 0
       || weights.length != profits.length
    )
    return -1;

    if(capacity == 0) return 0;

    int[][] dp = new int[profits.length][capacity + 1];
    for(int i = 0; i < profits.length; i++){

        dp[i][0] = 0;
    }
    for(int i = 0; i <= capacity; i++){

        dp[0][i] = weights[0] <= i ? profits[0] : 0;
    }
    for(int i = 1; i < profits.length; i++){

        for(int c = 1; c <= capacity; c++){
            if(weights[i] <= c){
                dp[i][c] = Math.max(dp[i-1][c], profits[i] + dp[i-1][c - weights[i]]);
            } else{
               dp[i][c] = dp[i-1][c];
            }
        }
    }
    return dp[profits.length - 1][capacity];
  }
}
