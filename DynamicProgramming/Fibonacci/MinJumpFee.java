/*
 * Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step.
 * Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step).
 * At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.
 */

public class MinJumpFee{

	public int countMinFee(int[]  fee){

		if(fee == null || fee.length == 0) return 0;
		int[] dp = new int[fee.length + 1];
		dp[0] = 0;
		dp[1] = dp[2] = dp[3] = fee[0];

		for(int i = 4;i <= fee.length; i++)
		       dp[i] = Math.min(dp[i -1] + fee[i - 1] ,
				       Math.min(dp[i - 2] + fee[i - 2], dp[i - 3] + fee[i - 3]));

	        return dp[fee.length];	
	}
}

