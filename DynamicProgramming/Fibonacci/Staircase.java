/*
 * Given a stair with n steps, implement a method to count how many possible ways to reach top of the staircase
 * Every attempt could be a leap of 1/2/3 steps
 */

class Stairs{

	public int countWaysRec(int n){

		if(n == 0 || n == 1) return 1;
		
		return n == 2 ? 2 : countWaysRec(n - 3) + countWaysRec(n - 2) + countWaysRec(n - 1);
	}

	public int countWaysTDM(int n){

		int[] dp = new int[n + 1];
		countWaysTDMUtil(dp, n);
	}

	private int countWaysTDMUtil(int[] dp, int n){

		if(n == 0 || n == 1) return 1;
		if(n == 2) return n;
		if(dp[n] == 0){

			dp[n] = countWaysTDMUtil(dp, n - 1) + countWaysTDMUtil(dp, n - 2) + countWaysTDMUtil(dp, n - 3);				
		}
		return dp[n];
	}

	public int countWaysBUDP(int n){

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++)
		       dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
	        return dp[n];	
	}

	public int countWaysDPOptimized(int n){

		if(n == 0 || n == 1) return 1;
		if(n == 2) return n;
		int step1 = 1, step2 = 1, step3 = 2, temp = 0;
		for(int i = 3; i <= n; i++){
 
			temp = step1 + step2 + step3;
			step1 = step2;
			step2 = step3;
			step3 = temp;
		}
		return step3
	}
}
