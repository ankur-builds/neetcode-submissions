class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[] nums, boolean[] pick, List<Integer> list){
        // Base condition
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; ++i){
            if(!pick[i]){
                // Paths to add
                list.add(nums[i]);
                pick[i] = true;
                dfs(nums, pick, list);

                list.remove(list.size()-1);
                pick[i]=false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }
}
