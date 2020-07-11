import java.util.*;

class Subsets{

    public List<List<Integer>> findSubsets(int[] nums){

        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums){

            int size = subsets.size();
            for(int i = 0; i < size; i++){

                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
