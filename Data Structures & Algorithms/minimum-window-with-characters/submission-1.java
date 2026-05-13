class Solution {

    public String minWindow(String s, String t) {

        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        for(char ch : t.toCharArray()){
            tFreq.merge(ch, 1, Integer::sum);
        }

        int formed = 0;
        int required = tFreq.size();
        int left = 0;
        String min = "";

        for(int right = 0; right < s.length(); ++right){
            char ch = s.charAt(right);
            sFreq.merge(ch, 1, Integer::sum);

            if(tFreq.containsKey(ch) &&
               sFreq.get(ch).intValue() == tFreq.get(ch).intValue()){
                formed++;
            }

            while(formed == required){
                // UPDATE ANSWER FIRST
                if(min.isEmpty() ||
                   (right - left + 1) < min.length()){
                    min = s.substring(left, right + 1);
                }

                // SHRINK WINDOW
                char leftChar = s.charAt(left);
                sFreq.put(leftChar, sFreq.get(leftChar) - 1);

                if(tFreq.containsKey(leftChar) &&
                   sFreq.get(leftChar) < tFreq.get(leftChar)){
                    formed--;
                }

                left++;
            }
        }

        return min;
    }
}