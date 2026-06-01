class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    List<String> result = new ArrayList<>();
    private void buildTrieNodes(TrieNode curr, String word){
        for(int i = 0; i<word.length(); ++i){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
        }

        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode rootSearch = new TrieNode();

        // Build Prefix tree for search words 
        for(String word : words)
            buildTrieNodes(rootSearch, word);

        // Traverse through each row and column as starting point and check if word is found in board
        for(int r = 0; r<board.length; ++r){
            for(int c = 0; c<board[0].length; ++c){
                traverseBoard(board, r, c, rootSearch);
            }
        }

        return result;
    }

    private void traverseBoard(char[][] board, int r, int c, TrieNode search){
        if(r<0 || r==board.length || c<0 || c==board[0].length)
            return;
        
        // Traverse children to find the word
        char ch = board[r][c];
        if(ch=='#' || search == null || search.children[ch-'a']==null){
            return;
        }

        search = search.children[ch-'a'];
        if(search.word!=null){
            result.add(search.word);
            search.word = null;
        }

        board[r][c] = '#';
        traverseBoard(board, r, c + 1, search);
        traverseBoard(board, r, c-1, search);
        traverseBoard(board, r - 1, c, search);
        traverseBoard(board, r + 1, c, search);

        board[r][c] = ch;
    }
}