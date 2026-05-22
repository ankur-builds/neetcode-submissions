class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1, right = 0;
        for(int pile : piles)
            right = Math.max(right, pile);

        int min = right;

        while(left<=right){
            int mid = (left+right)/2;
            int hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double)pile/mid);
            }

            if(h<hours){
                left = mid+1;
            } else{
                right = mid-1;
                min = Math.min(min, mid);
            }
        }

        return min;
    }
}
