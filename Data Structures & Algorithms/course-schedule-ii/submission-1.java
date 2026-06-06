class Solution {
    List<Integer> order = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Populate adjacency list
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i<numCourses; ++i){
            adj[i] = new ArrayList<>();
        }

        for(int[] course : prerequisites){
            adj[course[0]].add(course[1]);
        }

        // Iterate over every courses and store their ordering
        
        boolean[] validCourses = new boolean[numCourses];

        for(int c = 0; c<numCourses; ++c){
            if(!dfs(c, adj, validCourses, new boolean[numCourses]))
                return new int[]{};
        }

        return order.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    private boolean dfs(int course, List<Integer>[] adj, boolean[] valid, boolean[] visited){
        if(visited[course])
            return false;

        if(valid[course])
            return true;

        visited[course] = true;
        for(int c : adj[course]){
            if(!dfs(c,adj,valid,visited))
                return false;
        }

        order.add(course);
        visited[course] = false;
        valid[course] = true;
        return true;
    }
}
