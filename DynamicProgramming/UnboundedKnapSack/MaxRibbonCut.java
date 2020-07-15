/**
 * Given a ribbon of length n and a set of possible ribbon lengths, 
 * cut the ribbon into maximum number of pieces that complies
 * with the given possible lengths
 */

public class CutRibbon{

	public int countRibbonPieces(int[] ribbons, int total){

		if(total == 0) return 0;
		if(ribbons == null || ribbons.length == 0) return -1;

		int n = ribbons.length;
		int[][] dp = new int[n][total + 1];

		for(int i = 0; i < n; i++)
			for(int j = 0; j <= total; j++)
				dp[i][j] = 0;

		for(int i = 0; i < n; i++)
			dp[i][0] = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++)
			for(int j = 1; j <= total; j++){

				if(i > 0)
					dp[i][j] = dp[i - 1][j]; // skip this length
				if(j >= ribbons[i] && dp[i][j - ribbons[i]] != Integer.MIN_VALUE)
					dp[i][j] = Math.max(dp[i][j] , dp[i][j - ribbons[i]]  + 1);
		}
		return dp[n - 1][total] == Integer.MIN_VALUE ? -1 : dp[n - 1][total];
	}
}
