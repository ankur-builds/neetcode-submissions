class Solution {
    public boolean canKokoFinish(int[] piles, int speed, int maxHours){
        int hours = 0;
        for(int pile : piles){ 
            /*
            hours += Math.ceil((double)pile/speed);
            Casting integers to double, performing floating-point division, 
            and calling a math library function adds significant CPU overhead
            inside your inner loop.
            */
            hours += (pile+speed-1)/speed;

            if(hours>maxHours)
                return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1, right = 0;
        for(int pile : piles)
            right = Math.max(right, pile);

        int min = right;

        while(left<=right){
            int mid = (left+right)/2;

            if(canKokoFinish(piles, mid, h)){
                right = mid-1;
                min = Math.min(min, mid);
            } else{
                left = mid+1;
            }
        }

        return min;
    }
}
