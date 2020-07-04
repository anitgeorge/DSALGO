import java.util.*;

class LongestSubstringKDistinct{

    public static int findLength(String str, int k){

        if(str == null || str.length() == 0
           || k < 0 || k > str.length()
        ) return 0;

        Set<Character> set = new HashSet<>();

        int start = 0, end = 0, max = Integer.MIN_VALUE;

        while(end < str.length()){

            set.add(str.charAt(end));

            if(set.size() == k){

                max = Math.max(max, end - start + 1);
            }
            while(set.size() > k){

              set.remove(str.charAt(start++));
            }

            end++;
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
