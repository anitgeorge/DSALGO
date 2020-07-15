import java.util.*;

class Fibonacci{

    public int computeFibonacci(int n){

         if(n < 2) return n;
         int val1 = 0, val2 = 0,temp = 0;
         for(int i = 2; i <= n; i++){

             temp = val1 + val2;
             val1 = val2;
             val2 = temp;
         }

         return val2;

         /**

             int[] dp = new int[n + 1];
             dp[0] = 0;
             dp[1] = 1;

             for(int i = 2; i <= n; i++){

                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
         */
    }
}

