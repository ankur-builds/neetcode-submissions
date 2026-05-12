class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;

        int left = 0, right = left+1;
        int maxProfit = 0;

        while(right<prices.length){
            int profit = prices[right]-prices[left];
            maxProfit = Math.max(maxProfit, profit);
            if (profit<0)
                left = right;
            
            right++;
        }

        return maxProfit;
    }
}
