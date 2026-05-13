class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(char ch : s1.toCharArray())
            count1[ch-'a']++;

        int window = s1.length();
        for(int right = 0; right<s2.length(); ++right){
            count2[s2.charAt(right)-'a']++;

            if(right >= window){
                // Slide window towards right
                count2[s2.charAt(right-window)-'a']--; 
            }

            if (Arrays.equals(count1, count2))
                return true;
        }

        return false;
    }
}
