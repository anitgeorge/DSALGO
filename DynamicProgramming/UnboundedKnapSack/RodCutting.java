import java.util.*;

class RodCutting {

  public int solveRodCutting(int[] lengths, int[] prices, int n) {

     if(lengths == null || lengths.length == 0
        || prices == null || prices.length == 0
        || prices.length != lengths.length || n <= 0
     ) return 0;

     int[][] dp = new int[prices.length][n + 1];
     for(int i = 0; i < prices.length; i++)
        dp[i][0] = 0;

     for(int i = 0; i < prices.length; i++){

        for(int j = 0; j <= n; j++){

            int profit1 = 0, profit2 = 0;
            if(j >= lengths[i])
               profit1 = prices[i] + dp[i][j - lengths[i]];
            profit2 = dp[i - 1][j];

            dp[i][j] = Math.max(profit1, profit2);
        }
     }

     return dp[lengths.length - 1][n];
  }
