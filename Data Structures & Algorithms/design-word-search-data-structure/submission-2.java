class WordDictionary {
    TrieNode root;

    class TrieNode{
        TrieNode[] children;
        boolean endOfWord;

        TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
        };
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        int n = word.length();
        for(int i = 0; i<n; ++i){
            char ch = word.charAt(i);

            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();

            curr = curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }

    public boolean dfs(String word, TrieNode curr, int start){
        int n = word.length();
        for(int i = start; i<n; ++i){
            char ch = word.charAt(i);

            if(ch=='.'){
                TrieNode temp;
                for(int j = 0; j<curr.children.length; ++j){
                    temp = curr.children[j];
                    if(temp!=null && dfs(word, temp, i + 1))
                        return true; 
                }
                return false; // If no match found 
            } else if(curr.children[ch-'a']==null)
                return false;
            else
                curr = curr.children[ch-'a'];
        }

        return curr.endOfWord;
    }

    public boolean search(String word) {
        return dfs(word, this.root, 0);
    }
}
