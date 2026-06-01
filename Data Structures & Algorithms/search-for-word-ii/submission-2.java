class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }

    Set<String> result = new HashSet<>();
    boolean[][] visited;
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
        visited = new boolean[board.length][board[0].length];

        // Build Prefix tree for search words 
        for(String word : words)
            buildTrieNodes(rootSearch, word);

        // Traverse through each row and column as starting point and check if word is found in board
        for(int r = 0; r<board.length; ++r){
            for(int c = 0; c<board[0].length; ++c){
                System.out.printf("-------- Row : %d, Column : %d------- %n", r, c);
                traverseBoard(board, r, c, rootSearch, '.');
            }
        }

        return new ArrayList<>(result);
    }

    private void traverseBoard(char[][] board, int r, int c, TrieNode search, char prev){
        if(r<0 || r==board.length || c<0 || c==board[0].length || visited[r][c])
            return;
        
        // Traverse children to find the word
        char ch = board[r][c];
        // System.out.printf("Character :%s, ", ch);
        if(search == null || search.children[ch-'a']==null){
            // System.out.printf("Children not found at %s from %s%n", ch, prev);
            return;
        }

        search = search.children[ch-'a'];
        if(!search.word.isEmpty()){
            // System.out.printf("**** Word found, word : %s**** %n", search.word);
            result.add(search.word);
        }

        visited[r][c] = true;
        prev = ch;
        // System.out.println("Going right from " + prev);
        traverseBoard(board, r, c + 1, search, prev);
        // System.out.println("Going left from " + prev);
        traverseBoard(board, r, c-1, search, prev);
        // System.out.println("Going up from " + prev);
        traverseBoard(board, r - 1, c, search, prev);
        // System.out.println("Going down from " + prev);
        traverseBoard(board, r + 1, c, search, prev);

        visited[r][c] = false;
    }
}