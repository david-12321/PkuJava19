
public class PowerOfTwo
{

	public static void main(String[] args)
	{
		PowerOfTwo pt = new PowerOfTwo();
		System.out.println(pt.isPowerOfTwo(15));
	}

    public boolean isPowerOfTwo(int n) {
    	if(n<1)
    		return false;
    	int count=0;
		int m = n-1;
		
		while(n!=0)
		{
			n=n&m;
			m=n-1;
			count++;
		}
        return count==1;
    }
}
