class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false; 

        int[] charlistA = new int[26];
        int[] charlistB = new int[26];

        for (char ch : s.toCharArray()){
            charlistA[ch-'a']++;
        }

        for (char ch : t.toCharArray()){
            charlistB[ch-'a']++;
        }

        for(int i = 0; i<26; ++i){
            if (charlistA[i]!=charlistB[i])
                return false;
        }
        return true;
    }
}
