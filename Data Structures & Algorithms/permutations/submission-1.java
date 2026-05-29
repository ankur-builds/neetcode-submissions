class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[] nums, boolean[] visited, List<Integer> list){
        // Base condition
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; ++i){
            if(!visited[i]){
                // Paths to add
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, list);

                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }
}
