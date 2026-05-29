class Solution {
    List<String> list = new ArrayList<>();

    private void dfs(int n, StringBuilder sb, int open, int close){
        if(open==n && close==n){
            list.add(sb.toString());
            return;
        }

        if (open==close && open<n){
            // Add open
            sb.append("(");
            dfs(n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        } else if(open>close){
            // Add open paranthesis
            if(open<n){
                sb.append("(");
                dfs(n, sb, open + 1, close);
                sb.deleteCharAt(sb.length() - 1);
            }

            // Add close paranthesis
            sb.append(")");
            dfs(n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs(n, new StringBuilder(), 0, 0);
        return list;
    }
}