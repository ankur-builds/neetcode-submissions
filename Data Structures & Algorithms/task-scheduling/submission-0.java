class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        int max = 0;
        for(char task : tasks){
            count[task-'A']++;
            max = Math.max(max, count[task-'A']);
        }

        int maxFreqCount = 0;
        for(int i = 0; i<26; ++i){
            if(count[i]==max)
                maxFreqCount++;;
        }

        // Interval = Max characters + interval b/w max character + left over characters
        int interval = max + (max-1)*n + maxFreqCount-1;
        return (tasks.length>interval) ? tasks.length : interval;
    }
}
