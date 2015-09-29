import java.math.BigInteger;


public class Atoi
{

	public static void main(String[] args)
	{
		String str = "12   33 -+3455-2dfqer";
		int n = new Atoi().myAtoi(str);
		System.out.println(n);
	}
	
	// 要考虑的问题：
	// 非法字符
	// 负数
	// 上下界(如何处理)
	// ？？
	//
	//
	//
	public int myAtoi(String str) 
	{
		int result=0;
		long tempResult=0;
		
		char[] cStr=str.toCharArray();
		boolean whiteSpaceFlag=true;
		boolean signFlag=true;
		char sign='+';
		
		for(int i=0;i<cStr.length;i++)
		{
			if(cStr[i]==' ' && whiteSpaceFlag)
			{
				continue;
			}
			if((cStr[i]=='+'||cStr[i]=='-')&&signFlag)
			{
				sign=cStr[i];
				signFlag=false;
				whiteSpaceFlag=false;
				continue;
			}
			else if(cStr[i]<'0'||cStr[i]>'9')
			{
				break;
			}
			else 
			{
				signFlag=false;
				whiteSpaceFlag=false;
				tempResult *=10;
				switch (cStr[i])
				{
					case '0':
						break;
					case '1':
						tempResult += 1;
						break;
					case '2':
						tempResult+=2;
						break;
					case '3':
						tempResult+=3;
						break;
					case '4':
						tempResult+=4;
						break;
					case '5':
						tempResult+=5;
						break;
					case '6':
						tempResult+=6;
						break;
					case '7':
						tempResult+=7;
						break;
					case '8':
						tempResult+=8;
						break;
					case '9':
						tempResult+=9;
						break;
					default:
						break;
				}

				if(sign=='+'&&tempResult>2147483647)
				{
					return 2147483647;
				}
				//else if(sign=='-'&&tempResult>214748368)
				else if(sign=='-'&&tempResult>2147483648L)
				{
					return -2147483648;
				}
			}
		}
		result = (int)tempResult;
		if(sign=='-')
		{
			result=0-result;
		}
		
		return result;
		
//		for(int i=cStr.length-1;i>=0;i--)
//		{
//			if(cStr[i]<'0'||cStr[i]>'9')
//			{
//				System.out.println("");
//				break;
//			}
//			else 
//			{
//			}
//			weight *= 10;
//		}
	}
}