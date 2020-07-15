import java.util.*;

public class CoinChange2{

	public int coinChange(int[] coins, int sum){

		if(sum == 0) return 0;
		if(coins == null || coins.length == 0) return -1;

		int[][] dp = new int[coins.length][sum + 1];
		for(int i = 0; i < coins.length; i++)
			for(int j = 0; j <= sum; j++)
				dp[i][j] = Integer.MAX_VALUE;

		for(int i = 0; i < coins.length; i++)
			dp[i][0] = 0;

		for(int i = 0; i < coins.length; i++)
			for(int j = 1; j <= sum; j++){

				if(i > 0)
					dp[i][j] = dp[i - 1][j]; //exclude the coin
				if( j >= coins[i] && coins[i][j - coins[i]] != Integer.MAX_VALUE)
					dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
		}
		return dp[coins.length - 1][sum];
	}
}
