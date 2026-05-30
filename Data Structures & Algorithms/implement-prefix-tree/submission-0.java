class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    private boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(char ch : word.toCharArray()){
            if(!curr.map.containsKey(ch))
                curr.map.put(ch, new TrieNode());
            curr = curr.map.get(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(char ch : word.toCharArray()){
            if (curr.map.containsKey(ch))
                curr = curr.map.get(ch);
            else
                return false;
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(char ch : prefix.toCharArray()){
            if (curr.map.containsKey(ch))
                curr = curr.map.get(ch);
            else
                return false;
        }

        return true;
    }
}
