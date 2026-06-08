class Solution {
    // Eulerian Path - visit every edge once
    // Hierholzer's Algorithm
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!graph.containsKey(from))
                graph.put(from, new PriorityQueue());
            
            graph.get(from).add(to);
        }    
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String airport){
        PriorityQueue<String> pq = graph.get(airport);
        while(pq!=null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next);
        }

        itinerary.addFirst(airport);
    }
}
