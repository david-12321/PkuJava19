
public class ReverseWords
{

	public static void main(String[] args)
	{
		String s = " the sky  is blue ";
		s=new ReverseWords().reverseWords(s);
		System.out.println(s);
	}

	public String reverseWords(String s) 
	{
		StringBuilder sb = new StringBuilder();
		s=s.trim();
		String[] sArr = s.split(" ");
		
		for(int i=sArr.length-1;i>=0;i--)
		{
			if(!sArr[i].isEmpty())
			{
				sb.append(sArr[i].trim());
				sb.append(" ");
			}
		}
		
		return sb.toString().trim();
	}
}
