import java.util.HashMap;


public class HappyNumber
{

	public static void main(String[] args)
	{
		int n=11;
		boolean b=false;
		b = new HappyNumber().isHappy(n);
		System.out.println(b);
	}

	 public boolean isHappy(int n) 
	 {
		 
		 if(n < 1)
			 return false;
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 map.put(n, 0);
//		 int temp = 0;
//		 int temp = n;
//		 while(temp!=1&&temp!=n)
//		 while(temp!=1)
		 while(n!=1)
		 {
//			 temp=n;
			 int sum = 0;
//			 int tMod=temp%10;
			 int tMod=n%10;
//			 while(tMod!=0)
//			 while(tMod!=0 || temp !=0)
			 while(tMod!=0 || n!=0)
			 {
				 sum +=tMod*tMod;
//				 temp = temp/10;
				 n = n/10;
//				 tMod = temp%10;
				 tMod = n%10;
//				 temp = temp/10;
			 }
//			 if(sum == n)
			 if(map.containsKey(sum))
				 return false;
			 else 
			 {
				 map.put(sum, 0);
				 n=sum;
			 }
//			 temp=sum;
		 }
//		 if(temp==1)
		 return true;
//		 else {
//			return false;
//		}
	 }
}
