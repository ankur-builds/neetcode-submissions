class Solution {
    // Minimum Spanning Tree - Kruskal(Union Find) or Prim(PriorityQueue)
    // A tree that contains every vertex and has minimum total edge weight
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] {0,0});

        int minCost = 0;
        int count = 0;
        while(count<n){
            int[] curr = pq.poll();
            int dist = curr[0];
            int indx = curr[1];

            if(visited[indx])
                continue;
            visited[indx] = true;
            minCost += dist;
            count++;

            for(int next = 0; next<n; ++next){
                if(visited[next])
                    continue;
                
                int d = Math.abs(points[indx][0]-points[next][0]) + Math.abs(points[indx][1]-points[next][1]);
                pq.add(new int[] {d, next});
            }
        }
        return minCost;
    }
}
