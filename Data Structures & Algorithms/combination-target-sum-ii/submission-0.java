class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[] candidates, int indx, int target, List<Integer> list){
        // Base condition
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(indx == candidates.length){
            return;
        }

        // Paths to take
        list.add(candidates[indx]);
        if(candidates[indx]<=target)
            dfs(candidates, indx+1, target-candidates[indx],list);

        list.remove(list.size()-1);
        while(indx<candidates.length-1 && candidates[indx]==candidates[indx+1])
            indx++;
        dfs(candidates, indx+1, target,list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return result;
    }
}
