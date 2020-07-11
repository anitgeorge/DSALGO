class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int start = 0, end = 0;
        for(int i = 0; i< nums.length ; i++){
            start = 0;
            if(i > 0 && nums[i] == nums[i - 1]){
                
                start = end + 1;
            }
            
            end = subsets.size() - 1;
            
            for(int j = start; j <= end; j++){
                
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        
        return subsets;
    }
}
