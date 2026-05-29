class Solution {
    List<String> result = new ArrayList<>();
    public void backtrack(String digits, int indx, StringBuilder sb, char[][] value){
        if(indx==digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(indx));
        for(int i = 0; i<value[digit].length; ++i){
            sb.append(value[digit][i]);
            backtrack(digits, indx + 1, sb, value);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()>0){
            char[][] value = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
                        {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'},{'w','x','y', 'z'}};

            backtrack(digits, 0, new StringBuilder(), value);
        }

        return result;
    }
}
