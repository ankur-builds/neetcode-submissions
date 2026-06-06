class Solution {
    // Valid Tree means all vertices are connected and there is no cycle
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n)
            return false;

        // Give edge list, compute adjacency list
        List<Integer>[] adj = new List[n];
        for(int i = 0; i<n; ++i){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i<edges.length; ++i){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        // run dfs to check if there are any cycles 
        // a single dfs should cover all vertices, if anything is left then its not a valid tree
        if(!dfs(0, -1, adj, visited)){
            return false;
        }

        for(int i = 0; i<n; ++i){
            if(visited[i]==false)
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean[] visited){
        if(visited[node]) // Cycle detected
            return false;

        visited[node] = true;

        for(int i : adj[node]){
            if(i==parent)
                continue;
            if(!dfs(i, node, adj, visited))
                return false;
        }

        return true;
    }
}
