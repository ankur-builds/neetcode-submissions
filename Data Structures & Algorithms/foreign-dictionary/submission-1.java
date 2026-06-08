class Solution {
    // Topological sort (Kahn's Algorithm)
    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words){
            for (char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i<n-1; ++i){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2))
                return ""; // Invalid words
            
            int len = w1.length();
            for(int j = 0; j<len; ++j){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1!=c2){
                    if(!adj.get(c1).contains(c2)){
                        adj.get(c1).add(c2);
                        indegree.merge(c2, 1, Integer::sum);
                    }

                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c)==0)
                q.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);

            for(char c : adj.get(ch)){
                indegree.put(c, indegree.get(c)-1);
                if(indegree.get(c)==0)
                    q.offer(c);
            }
        }

        return (sb.length()==indegree.size()) ? sb.toString() : "";
    }
}
