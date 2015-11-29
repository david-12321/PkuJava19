
public class BestTimeStock
{

	public static void main(String[] args)
	{
		
	}
		
    public int maxProfit(int[] prices) {
    	if(prices.length<1)
    		return 0;
    	
    	int maxProfit = 0;
    	int curMin=prices[0];
    	
    	for(int i=1;i<prices.length;i++)
    	{
    		curMin= Math.min(curMin, prices[i]);
    		maxProfit = Math.max(maxProfit, prices[i]-curMin);
    	}
        
    	return maxProfit;
    }
}
