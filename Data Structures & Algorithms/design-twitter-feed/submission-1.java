class Twitter {
    class Node {
        int tweetId;
        int timestamp;

        Node (int x, int y){
            this.tweetId = x;
            this.timestamp = y;
        };
    }

    private Map<Integer, List<Node>> tweetMap;
    private Map<Integer, Set<Integer>> followersMap;
    private int counter = 0;

    public Twitter() {
        tweetMap = new HashMap<>();
        followersMap = new HashMap<>();    
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        Node node = new Node(tweetId, ++counter); 
        tweetMap.get(userId).add(node);
    }
    
    private List<Node> lastTenNodes(int userId){
        if(tweetMap.containsKey(userId)){
            List<Node> tweetList = tweetMap.get(userId);
            int n = tweetList.size();
            return (n>=10) ? tweetList.subList(n-10, n) : tweetList;
        }

        return null;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.timestamp, a.timestamp));
        if(tweetMap.containsKey(userId))
            pq.addAll(tweetMap.get(userId));

        if (followersMap.containsKey(userId)){
            Set<Integer> followeeSet = followersMap.get(userId);
            for(int user : followeeSet){
                List<Node> nodes = lastTenNodes(user);
                if(nodes.size()>0){
                    pq.addAll(nodes);
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        int feedCount = 10;
        while(!pq.isEmpty() && feedCount>0){
            newsFeed.add(pq.poll().tweetId);
            feedCount--;
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return;
        followersMap.putIfAbsent(followerId, new HashSet<>());
        followersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.containsKey(followerId)){
            Set<Integer> followeeSet = followersMap.get(followerId);
            if(followeeSet.contains(followeeId)){
                if (followeeSet.size()==1)
                    followersMap.remove(followerId);
                else
                    followeeSet.remove(followeeId);
            }
        }
    }
}
