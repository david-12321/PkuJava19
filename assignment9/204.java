// leetcode 204
public class CountPrimes
{

	public static void main(String[] args)
	{
		int n = 2;
		System.out.println(new CountPrimes().countPrimes(n));
	}

    public int countPrimes(int n) 
    {
		if(n<2)
			return 0;
		
	    boolean[] boo = new boolean[n];
	    for(int i=2;i<n;i++) boo[i]=true;
	    for(int i=2;i*i<n;i++)
	    {
	    	if(boo[i])
	    	{
	    		for(int j = 2;j*i<=n-1;j++)
	    			boo[j*i]=false;
	    	}
	    }
	    
	    int res = 0;
	    for(int i=2;i<n;i++)
	    	if(boo[i])
	    		res++;
	    
	    return res;
    }
}
