class TimeMap {
    // Custom class to pair a timestamp with its value
    private static class DataNode {
        int timestamp;
        String value;
        
        DataNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    // Outer Map holds an ArrayList instead of a TreeMap
    private Map<String, List<DataNode>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(timestamp, value));
    }

    public String get(String key, int timestamp) {
        // Step 1: Safety check
        if (!map.containsKey(key)) return "";
        
        List<DataNode> timeline = map.get(key);
        
        // Step 2: Initialize Binary Search pointers
        int left = 0;
        int right = timeline.size() - 1;
        String result = ""; // Keeps track of our best "floor" candidate

        // Step 3: Binary Search Loop
        while (left <= right) {
            int mid = left + (right - left) / 2;
            DataNode currentNode = timeline.get(mid);

            if (currentNode.timestamp == timestamp) {
                // Perfect exact match found! Return immediately.
                return currentNode.value;
            } else if (currentNode.timestamp < timestamp) {
                // This timestamp is a valid candidate (historical match)
                result = currentNode.value; 
                // Keep searching to the right to see if there is a closer one
                left = mid + 1;
            } else {
                // This timestamp is too far in the future, search to the left
                right = mid - 1;
            }
        }

        // Step 4: Return the closest historical value found, or "" if none
        return result;
    }
}
