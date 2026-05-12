class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Populate count array of each character for String
        int[][] count = new int[strs.length][26];
        int k = 0;
        for(String str : strs){
            for(int i = 0; i<str.length(); ++i){
                count[k][str.charAt(i)-'a']++;
            }
            k++;
        }
        // Create a string key for count array
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; ++i){
            StringBuilder tmp = new StringBuilder();
            for(int j = 0; j<26; ++j){
                tmp.append(String.valueOf(count[i][j]));
                tmp.append("-");
            }
            // If string key exists then add original string in List
            List<String> group =  map.getOrDefault(tmp.toString(), new ArrayList<String>());
            group.add(strs[i]);
            map.put(tmp.toString(), group);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
