
public class ExcelNumer
{

	public static void main(String[] args)
	{
		ExcelNumer en = new ExcelNumer();
		//en.titleToNumber("AA");
		System.out.println(en.titleToNumber("BA"));
	}
	
    public int titleToNumber(String s) {
    	s = s.toUpperCase();
    	int result = 0;
    	for(int i= s.length()-1,count=0;i>=0;i--,count++)
    	{
    		result += ((int)s.charAt(i)-64)*Math.pow(26, count);
    	}
        return result;
    }
}
