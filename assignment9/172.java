// leetcode 172
public class FactorialTrailingZeroes
{

	public static void main(String[] args)
	{
		int n=30;
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));
	}

    public int trailingZeroes(int n) {
    	int count = 0;
        while(n!=0)
        {
        	count+=n/5;
        	n=n/5;
        }
        return count;
    }
}
