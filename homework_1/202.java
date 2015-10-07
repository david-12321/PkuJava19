public class Solution {
    public boolean isHappy(int n) {
        int x,sum = n;
        while( (sum/10) != 0)
        {
        	n = sum;
        	sum = 0;
        	while(n > 0)
        	{
        		x = n % 10;
            	sum += x * x;
            	n = n / 10;
        	}
        }
        if(sum == 1 || sum == 7)
        	return true;
        else
        	return false;
    }
}