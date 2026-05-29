class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[] nums, int indx, List<Integer> list){
        if(indx==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[indx]);
        dfs(nums, indx+1, list);

        list.remove(list.size()-1);
        while((indx<nums.length-1) && (nums[indx] == nums[indx+1]))
            indx++;
        dfs(nums, indx+1, list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return result;
    }
}
