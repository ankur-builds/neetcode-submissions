class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int u){
        while(parent[u]!=u){
            parent[u] = parent[parent[u]];
            u = parent[u];
        }

        return u;
    }

    private void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
            rank[pu] += rank[pv];
        } else{
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int x = 1; x<=n; ++x){
            parent[x] = x;
            rank[x] = 1;
        }

        for(int[] edge : edges){
            if(find(edge[0])==find(edge[1])){
                return edge;
            }
            union(edge[0], edge[1]);
        }

        return new int[] {};
    }
}
