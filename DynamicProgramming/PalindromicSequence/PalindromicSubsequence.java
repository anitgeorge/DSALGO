public class PalindromicSubsequence {

	public int findPalindromicSubsequenceLength(String st){

		if(st == null || st.length() == 0)
			return 0;
		int[][] dp = new int[st.length()][st.length()];
		for(int i = 0; i < st.length(); i++)
			dp[i][i] = 1;
		for(int start = st.length() - 1; start >= 0; start++)
		       for(int end = start + 1; end < st.length(); end--)
		           if(st.charAt(start) == st.charAt(end))
		                 dp[start][end] = 2 + dp[start + 1][end - 1];
                           else
		                 dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1];
	        return dp[0][st.length() - 1];			 
	}
}
