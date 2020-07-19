import java.util.*;

class MinJumps{

    public int countMinJumps(int[] jumps){

        if(jumps == null || jumps.length == 0) return 0;
        int[] dp = new int[jumps.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int start = 0; start < jumps.length; start++)
           for(int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++)
               dp[end] = Math.min(dp[end], dp[start] + 1);

        return dp[jumps.length - 1];
    }
}
