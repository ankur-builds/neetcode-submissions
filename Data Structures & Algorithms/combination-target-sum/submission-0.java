class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void dfs(int[] nums, int indx, int target, List<Integer> list){
        // Base Condition
        if(indx == nums.length || target<0)
            return;

        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }

        // Paths to take
        list.add(nums[indx]);
        dfs(nums, indx, target-nums[indx], list);

        list.remove(list.size()-1);
        dfs(nums, indx+1, target, list);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>());
        return result;
    }
}
