class Solution { 
    List<List<Integer>> result = new ArrayList<>();

    private void findSubsets(int[] nums, int indx, List<Integer> subset){
        if(indx==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[indx]);
        findSubsets(nums, indx+1, subset);

        subset.remove(subset.size()-1);
        findSubsets(nums, indx+1, subset);
    }

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return result;
    }
}
