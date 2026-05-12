class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Single Pass
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i<str.length(); ++i){
                count[str.charAt(i)-'a']++;
            }
            // Arrays.toString() has inbuilt delimiter
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
