import java.util.*;

class CoinChange{

    public int coinChange(int coins, int sum){

        if(sum == 0) return 0;
        if(coins == null || coins.length == 0) return -1;

        int dp[][] = new int[coins.length][sum + 1];
        for(int i = 0; i < coins.length; i++) dp[i][0] = 1;

        for(int i=0; i < coins.length; i++){

          for(int j = 1; j <= sum; j++){

             dp[i][i] = dp[i - 1][j];
             if(j >= coins[i])
                dp[i][j] += dp[i][j - coins[i]];
          }
        }
        return dp[coins.length -1][sum];
    }
}
