class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; ++i){
                String word = q.poll();

                if(word.equals(endWord))
                    return level;

                char[] chars = word.toCharArray();
                for(int pos = 0; pos<chars.length; ++pos){
                    char original = chars[pos];
                    for(char ch = 'a'; ch<='z'; ++ch){
                        chars[pos] = ch;
                        String next = new String(chars);
                        if(dict.contains(next)){
                            q.offer(next);
                            dict.remove(next);
                        }
                    }

                    chars[pos] = original;
                }
            }
            level++;
        }

        return 0;
    }
}
