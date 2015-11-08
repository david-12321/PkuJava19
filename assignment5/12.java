
public class IntegerToRoman
{

	public static void main(String[] args)
	{
		int num=3104;
		System.out.println(new IntegerToRoman().intToRoman(num));
	}
	
    public String intToRoman(int num) 
    {
        String result = "";
        String[][] mapTable=
        	{  
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},  
                {"", "M", "MM", "MMM"}  
            }; 
        int n=0;
        int count=0;
        while(num!=0)
        {
        	n=num%10;
        	result=mapTable[count][n]+result;
        	count++;
        	num=num/10;
        }
        
        return result;
    }
}
