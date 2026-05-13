class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        
        char[] ch = s.toCharArray();

        int[] count = new int[128];
        int length = 0;
        int left = 0, right = left;
        while(right<ch.length){
            char key = ch[right];
            while (count[key]!=0){
                count[ch[left++]]--;
            }

            length = Math.max(length,right-left+1);
            count[key]++;
            right++;
        }

        return length;
    }
}
