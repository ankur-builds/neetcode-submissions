class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i<n; ++i){
            int m = strs[i].length();
            int[] count = new int[26];
            for (int j = 0; j<m; ++j){
                count[strs[i].charAt(j)-'a']++;
            }

            StringBuilder str = new StringBuilder();
            for (int k = 0; k<26; ++k){
                str.append(count[k]);
                str.append("$");
            }

            String key = str.toString();
            List<String> list;
            if(map.containsKey(key)){
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(key, list);
        }

        for(String key : map.keySet())
            result.add(map.get(key));

        return result;
    }
}
