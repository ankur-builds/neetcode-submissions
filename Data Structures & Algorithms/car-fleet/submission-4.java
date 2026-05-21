class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (target==0)
            return position.length;
        
        int[][] pairs = new int[position.length][2];
        for(int i = 0; i<position.length; ++i){
            pairs[i][0] = position[i]; 
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0],a[0]));

        int fleetSize = 0;
        double baseline = 0;
        for(int i = 0; i<position.length; ++i){
            double time = (double)(target-pairs[i][0])/pairs[i][1];

            if(time>baseline){
                baseline = time;
                fleetSize++;
            }
        }

        return fleetSize;
    }
}
