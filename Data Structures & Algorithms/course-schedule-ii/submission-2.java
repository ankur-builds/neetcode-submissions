class Solution {
    int[] order;
    int indx = 0;

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
        int[] state = new int[numCourses];
        order = new int[numCourses];

        for(int c = 0; c<numCourses; ++c){
            if(!dfs(c, adj, state))
                return new int[]{};
        }

        return order;
    }

    private boolean dfs(int course, List<Integer>[] adj, int[] state){
        if(state[course] == 1)  // Already visited. Cycle detected
            return false;

        if(state[course] == 2)  // Valid course
            return true;

        state[course] = 1;  // Visited
        for(int c : adj[course]){
            if(!dfs(c,adj,state))
                return false;
        }

        order[indx++] = course;
        state[course] = 2; // Memoization - valid state
        return true;
    }
}
