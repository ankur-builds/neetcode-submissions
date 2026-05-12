class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n <= 1) return n;

        int[] freq = new int[26];  // frequency of each uppercase letter
        int left = 0;
        int maxCount = 0;          // max frequency of a single char in current window
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxCount = Math.max(maxCount, freq[idx]);

            // If we need more than k replacements, shrink from the left
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
