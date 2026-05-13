class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        
        char[] ch = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int left = 0, right = left;
        while(right<ch.length){
            char key = ch[right];
            while (map.containsKey(key)){
                char leftChar = ch[left];
                if(map.get(leftChar)==1)
                    map.remove(leftChar);
                else
                    map.merge(leftChar, -1, (old, newV) -> old+newV);
                
                left++;
            }

            length = Math.max(length,right-left+1);
            map.merge(key, 1, (old, newV) -> old+newV);
            right++;
        }

        return length;
    }
}
