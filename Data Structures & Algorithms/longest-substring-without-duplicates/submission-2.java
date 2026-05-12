class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128];
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right<n; ++right){
            int indx = s.charAt(right);
            while(freq[indx]>0){
                freq[s.charAt(left)]--;
                left++;
            }

            freq[indx]++;
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
