class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str : strs){
            int[] count = new int[26];
            for (char ch : str.toCharArray())
                count[ch-'a']++;

            StringBuilder sb = new StringBuilder();
            for (int num : count){
                sb.append(num).append("$");
            }

            String key = sb.toString();
            List<String> list;
            if(map.containsKey(key)){
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
        }

        result.addAll(map.values());
        return result;
    }
}

/* Best Solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){

            int[] count = new int[26];

            for(int i = 0; i < str.length(); ++i){
                count[str.charAt(i)-'a']++;
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
*/