public class UglyNumber
{

	public static void main(String[] args)
	{
		int num=905391974;
		System.out.println(new UglyNumber().isUgly(num));
	}

	public boolean isUgly(int num) 
	{
		if(num<1)
			return false;
		
		while(num%2==0)
		{
			num /= 2;
		}
		while(num%3==0)
		{
			num /= 3;
		}
		while(num%5==0)
		{
			num /= 5;
		}
		
		if(num==1) 
			return true;
		else
			return false;
    }
}
