class Solution {
    public boolean isPalindrome(String s) {
        // Remove all whitespaces
        s = s.replaceAll("\\s+","");
        // Convert to lowercase
        s = s.toLowerCase();
        // Remove any non-alphanumeric characters
        s = s.replaceAll("[^A-Za-z0-9]", "");

        int n = s.length();
        if(n==0)
            return true;
        
        for(int i = 0; i<=n/2; ++i){
            if(s.charAt(i)!=s.charAt(n-i-1))
                return false;
        }
        return true;
    }
}
