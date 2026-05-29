class Solution {
    private boolean checkPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private List<List<String>> result = new ArrayList<>();

    private void backtrack(String s, int start, int end, List<String> list){
        if(end >= s.length()){
            if(start == end)
                result.add(new ArrayList<>(list));
            return;
        }

        if(checkPalindrome(s, start, end)){
            list.add(s.substring(start, end + 1));
            // Deep dive path - start with single step window. Expand it in explorer path
            backtrack(s, end + 1, end + 1, list);
            list.remove(list.size() - 1);
        }

        // Explorer path - expand window 
        backtrack(s, start, end + 1, list);
    }

    public List<List<String>> partition(String s) {
        backtrack(s, 0, 0, new ArrayList<>());
        return result;
    }
}

