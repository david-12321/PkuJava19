public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        int maxProfit = 0;
        int max = prices[0];
        int min = prices[0];
        
        for(int i=1; i<prices.length; i++){
            if(prices[i] >= max)
                max = prices[i];
            if(prices[i] < min)
            {
                if(maxProfit < max - min)
                    maxProfit = max - min;
                max = prices[i];
                min = prices[i];
            }
        }
        
        if(maxProfit < max - min)
            maxProfit = max - min;
        
        return maxProfit;
    }
}