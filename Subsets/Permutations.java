class Permutations {
    public List<String> letterCasePermutation(String S) {
        if(S.isEmpty())
            return new ArrayList<>();
        List<String> permutations = new ArrayList<>();
        permutations.add(S);
        for(int i = 0; i < S.length(); i++){
            
            if(!Character.isLetter(S.charAt(i)))
                continue;
            int n = permutations.size();
            for(int j = 0; j < n; j++){
                
                char[] chs = permutations.get(j).toCharArray();
                chs[i] = Character.isUpperCase(chs[i]) ?
                         Character.toLowerCase(chs[i]) :
                         Character.toUpperCase(chs[i]);
                permutations.add(String.valueOf(chs));
            }
        }
        return permutations;
    }
}
