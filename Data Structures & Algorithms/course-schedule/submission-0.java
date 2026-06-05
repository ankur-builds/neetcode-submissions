class Solution {
    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> set, int key){
        if(set.contains(key))
            return false;

        if(map.get(key).isEmpty())
            return true;

        set.add(key);
        List<Integer> list = map.get(key);
        for(int value : list){
            if(!dfs(map, set, value)){
                // cycle detected
                return false;
            }
        }

        set.remove(key);
        // null value because its confirmed that there is no cycle here
        map.put(key, new ArrayList<>()); 

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)
            return true;

        int ROWS = prerequisites.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i<numCourses; ++i){
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i<prerequisites.length; ++i){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i<numCourses; ++i){
            if(!dfs(map, set, i))
                return false;
        }

        return true;
    }
}
