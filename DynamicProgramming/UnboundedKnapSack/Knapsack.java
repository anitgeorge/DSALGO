import java.util.*;

class Knapsack{

     public int solveKnapsack(int[] weights, int[] profits, int capacity){

         if(weights == null || weights.length == 0
            || profits == null || profits.length == 0
            || capacity == 0 || weights.length != profits.length
         ) return 0;

         int[][] dp = new int[weights.length][capacity + 1];

         for(int i = 0; i < weights.length; i++){

             dp[i][0] = 0;
         }

         for(int i = 0; i < weights.length; i++){

             for(int j = 1; j <= capacity; j++){

                  int profit1 = 0;
                  if(j >= weights[i])
                     profit1 = dp[i][j - weights[i]];
                  if(i > 0)
                     profit2 = dp[i - 1][j];

                  dp[i][j] = Math.max(profit1, profit2);
             }
         }

         return dp[weights.length - 1][capacity];
     }
}
