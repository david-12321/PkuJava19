
public class AddBinary
{

	public static void main(String[] args)
	{
		String a ="1";
		String b = "111";
		a = new AddBinary().addBinary(a, b);
		System.out.println(a);
	}

	public String addBinary(String a, String b)
	{
		if(a.isEmpty()&&b.isEmpty())
			return "";

		int carry = 0;
		int newChar;
		StringBuilder sb = new StringBuilder();
		int i,j;
		for(i=a.length()-1,j=b.length()-1;i>=0&&j>=0;i--,j--)
		{
			byte aByte = Byte.parseByte(a.substring(i, i+1));
			byte bByte = Byte.parseByte(b.substring(j, j+1));
			newChar = aByte^bByte^carry;
			carry=(aByte&bByte)|((aByte|bByte)&carry);
			sb.append(newChar);
		}
		while(i>=0)
		{
			byte aByte = Byte.parseByte(a.substring(i, i+1));
			newChar = aByte^carry;
			sb.append(newChar);
			carry = aByte&carry;
			i--;
		}
		while(j>=0)
		{
//			byte bByte = Byte.parseByte(a.substring(j, j+1));
			byte bByte = Byte.parseByte(b.substring(j, j+1));
			newChar = bByte^carry;
			sb.append(newChar);
			carry = bByte&carry;
			j--;
		}
		
		if(carry==1)
			sb.append(1);
		
		return sb.reverse().toString();
	}
}
