class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        int n = s.length();
        int m = t.length();
        for(int i = 0; i<n; ++i)
            countS[s.charAt(i)-'a']++;

        for(int i = 0; i<m; ++i)
            countT[t.charAt(i)-'a']++;

        return Arrays.equals(countS, countT);
    }
}
