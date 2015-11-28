public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int max_profit = 0;
        int min = prices[0];
        int length = prices.length;
        for(int i = 1; i < length; i++)
        {
        	if(prices[i] - min > max_profit)
        		max_profit = prices[i] - min;
        	if(prices[i] < min)
        		min = prices[i];
        }
        return max_profit;
    }