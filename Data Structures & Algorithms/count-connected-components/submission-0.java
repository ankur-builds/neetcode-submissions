class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int components = 0;
        for(int i = 0; i<n; ++i){
            if(visited[i]==false){
                dfs(i, adj, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node, List<Integer>[] adj, boolean[] visited){
        if(visited[node]) // Cycle detected
            return;

        visited[node] = true;

        for(int i : adj[node]){
            dfs(i, adj, visited);
        }
    }
}
