class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n==0 || m==0 || m>n)
            return "";
        
        int[] freq = new int[128];

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        int left = 0;
        int len = Integer.MAX_VALUE;
        boolean found = false;
        String output = "";
        for (int right = 0; right<n; ++right){
            // Search for all characters
            if(freq[s.charAt(right)]>0)
                m--;
            
            freq[s.charAt(right)]--;

            // Found all characters, shrink window
            while(m==0){
                found = true;
                freq[s.charAt(left)]++;

                if(freq[s.charAt(left)]>0)
                    m++;
                if(left<n)
                    left++;
            }

            if(found){
                if(len>right-left+2){
                    output = s.substring(left-1, right+1);
                    len = right-left+2;
                }
            }
        }

        return output;
    }
}
