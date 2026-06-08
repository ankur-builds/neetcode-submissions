class Solution {
    // Dijkstra Algorithm
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new List[n+1];

        for(int i = 1; i<=n; ++i){
            adj[i] = new ArrayList<>();
        }

        for(int[] time : times){
            adj[time[0]].add(new int[] {time[1], time[2]}); 
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE); // so as to pick min distance
        distance[k] = 0; // Starting point

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[1],b[1])));
        pq.offer(new int[] {k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(time>distance[node])
                continue;

            for(int[] edge : adj[node]){
                int neighbor = edge[0];
                int weight = edge[1];

                int newTime = time+weight;

                if(newTime<distance[neighbor]){
                    distance[neighbor] = newTime;
                    pq.offer(new int[] {neighbor, newTime});
                }
            }
        }

        // Find maximum time taken to visit -> min time to visit all nodes
        int max = 0;
        for(int i = 1; i<=n; ++i){
            if(distance[i]==Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, distance[i]);
        }

        return max;
    }
}
