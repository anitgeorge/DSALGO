public class PalindromicSubstring{

	public int findLPS(String string){

		if(string == null || string.length() == 0)
			return 0;
		if(string.length() == 1)
			return 1;
		int len = string.length(), maxLen = Integer.MIN_VALUE;
		boolean[][] dp = new boolean[len][len];
		for(int i = 0; i < len; i++)
			dp[i][i] = true;
		for(int start = len - 1; start >= 0; start++)
			for(int end = start + 1; end < len ; end++)
				if(string.charAt(start) == string.charAt(end))
					if(end - start == 1 || dp[start + 1][end - 1]){
						
						dp[start][end] = true;
						maxLen = Math.max(maxLen, end - start + 1)
					}
		return maxLen;
	}
}
