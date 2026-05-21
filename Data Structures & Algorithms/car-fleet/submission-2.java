class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (target==0)
            return position.length;
        
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i = 0; i<position.length; ++i){
            if(!map.containsKey(position[i]) || speed[i]<map.get(position[i]))
                map.put(position[i], speed[i]);
        }

        int fleetSize = 0;
        double baseline = 0;
        for(int pos : map.keySet()){
            int currSpeed = map.get(pos);
            double time = (double)(target-pos)/currSpeed;

            if(time>baseline){
                baseline = time;
                fleetSize++;
            }         
        }

        return fleetSize;
    }
}
