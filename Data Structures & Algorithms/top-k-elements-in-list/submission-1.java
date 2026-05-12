class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.merge(num, 1, (oldValue, newValue) -> oldValue+newValue);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        list.sort(new Comparator<>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
                return Integer.compare(entry2.getValue(), entry1.getValue());
            };
        });

        int[] result = new int[k];
        for(int i = 0; i<k; ++i){
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
