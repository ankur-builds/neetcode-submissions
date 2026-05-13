class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();

        int left = 0, right = 0;
        int[] count = new int[26];
        int length = 0;
        int maxFreq = 0;

        while (right<ch.length){
            int key = ch[right]-'A';
            count[key]++;
            maxFreq = Math.max(maxFreq, count[key]);

            while(right-left+1 - maxFreq > k){
                count[ch[left]-'A']--;
                left++;
            }

            length = Math.max(length, right-left+1);
            right++;
        }

        return length;
    }
}
