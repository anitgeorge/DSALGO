class EditDistance {
    public int minDistance(String A, String B) {
        
        if(A == null && B == null) return 0;
        if(A == null || A.length() == 0) return B.length();
        if(B == null || B.length() == 0) return A.length();
        
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        
        for(int i = 0; i <= A.length(); i++)
            dp[i][0] = i;
        
        for(int j = 0; j <= B.length(); j++)
            dp[0][j] = j;
        
        for(int i = 0; i < A.length(); i++)
            for(int j = 0; j < B.length(); j++){
                
                if(A.charAt(i) == B.charAt(j))
                    dp[i+1][j+1] = dp[i][j];
                else{
                    
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        return dp[A.length()][B.length()];
    }
}
