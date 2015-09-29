
public class LengthOfLastWord
{

	public static void main(String[] args)
	{
		String s = "hello world ";
		int len = new LengthOfLastWord().lengthOfLastWord(s);
		
		System.out.println(len);
	}

	public int lengthOfLastWord(String s)
	{
		if(s.isEmpty())
			return 0;
		int len = 0;
		boolean whiteSpaceFlag=true;
		char[] charArr = s.toCharArray();
		
//		if(charArr[charArr.length-1]==' ')
//		{
//			return 0;
//		}
//		else 
//		{
		for(int i=charArr.length-1; i>=0;i--)
		{
			if(charArr[i]==' ' && whiteSpaceFlag)
			{
				continue;
			}
			else if(charArr[i]==' ' && !whiteSpaceFlag)
			{
				break;
			}
			else 
			{
				len++;
				whiteSpaceFlag=false;
			}
		}
//		}
		
		return len;
	}
}
