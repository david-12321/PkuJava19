import java.util.HashMap;


public class RomanToInteger
{

	public static void main(String[] args)
	{
		String s="MMMCDIVI";
		System.out.println(new RomanToInteger().romanToInt(s));
	}
	
    public int romanToInt(String s) 
    {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
        char[] c=s.toCharArray();
        int high = map.get(c[c.length-1]);
        int low=0;
        int num=high;
        
        for(int i=c.length-2;i>=0;i--)
        {
        	low = map.get(c[i]);
        	if(low<high)
        	{
        		num=num-low;
        	}
        	else 
        	{
				num=num+low;
			}
        	high = low;
        }
        
        return num;
    }
    
}
