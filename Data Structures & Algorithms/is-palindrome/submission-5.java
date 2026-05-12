class Solution {
    private boolean checkAlpha(char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int n = s.length();     
        int i = 0, j = n-1;  
        while(i<j) {
            while(i<j && !checkAlpha(s.charAt(i))){
                i++;
            }
            
            while (i<j && !checkAlpha(s.charAt(j))){
                j--;
            } 
            
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
