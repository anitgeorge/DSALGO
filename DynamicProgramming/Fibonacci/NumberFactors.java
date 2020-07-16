/*
 * Given a number n, compute all the ways to express it as a sum of 1,3,4
 */

public class NumberFactors{

	public int countWays(int n){
	
		if( n <= 2) return 1;
		return n == 3 ? 2 : countWays(n - 4) + countWays(n - 3) + countWays(n - 1);              
	}


	public int countWaysTD(int n){
	
		int[] dp = new int[n + 1];
		countWaysTDUtil(dp, n);
	}

	private int countWaysTDUtil(int[] dp, int n){

		if(n <= 2) return 1;
		if(n == 3) return 2;
		if(dp[n] == 0){
		
			dp[n] = countWaysTDUtil(dp, n - 4) + countWaysTDUtil(dp, n - 3) + countWaysTDUtil(dp, n - 1);
		}
		return dp[n];
	}

	public int countWaysDP(int n){

		if(n <= 2) return 1;
		if( n == 3) return 2;

		int[] dp  = new int[n + 1};

	        dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;
		for(int i =4; i <= n; i++)
			dp[i] = dp[i - 4] + dp[i - 3] + dp[i - 1];
		return dp[n];
	}
}
