class TrieNode {
    TrieNode[] children = new TrieNode[26];
    private boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (curr.children[ch-'a']!=null)
                curr = curr.children[ch-'a'];
            else
                return false;
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if (curr.children[ch-'a']!=null)
                curr = curr.children[ch-'a'];
            else
                return false;
        }

        return true;
    }
}

