/*
 * There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses. 
 * The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system.
 */

class HouseThief{

	public int findMax(int wealth[]){

		/* 
		 * findMaxUtil(int wealth[], int index){
		 *    
		 *    if(index  >= wealth.length) return 0;
		 *    return Math.max(wealth[i]+findMaxUtil(wealth, i + 2), findMaxUtil(wealth, i + 1)
		 *    }
		 */

		if(wealth == null || wealth.length == 0) return 0;
		int[] dp = new int[wealth.length + 1];
		dp[0] = 0;
		d[1] = wealth[0];
		for(int i = 2; i <= wealth.length.i++)
			dp[i] = Math.max(wealth[i-1] + dp[i -2], dp[i - 1]);
		return dp[wealth.length];
	}
}
