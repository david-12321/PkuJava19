public class Solution {
    public String addBinary(String a, String b) {
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int lena = stra.length;
        int lenb = strb.length;
        int c = 0;//进位
        char[] temp,answer;//暂存结果
        //if(lena > lenb)
        if(lena <= lenb)
        {
        	temp = new char[lenb];
        	int i,j;
        	//for(int i = lenb - 1, j = lena - 1; i >= 0; i--,j--)
        	for(i = lena - 1, j = lenb - 1; i >= 0; i--,j--)
        	{
        		temp[j] = (char) ('0' + ((stra[i] - '0' + strb[j] - '0' + c) % 2));
        		c = (stra[i] - '0' + strb[j] - '0' + c) / 2;
        		//strb[j] = (char) ('0' + ((stra[i] - '0' + strb[j] - '0') % 2));
        	}
        	//短数已经算完但仍有进位需要处理
        	if(c == 1)
        	{
        		for(; j >= 0; j--)
        		{
        			temp[j] = (char) ('0' + ((strb[j] - '0' + c) % 2));
            		c = (strb[j] - '0' + c) / 2;
        		}
        	}
        	//短数已经算完无进位需要处理
        	else
        	{
        		for(; j >= 0; j--)
        		{
        			temp[j] = strb[j];
        		}
        	}
        	//结果数组不够存储，需要扩充位数
        	if(c == 1)
        	{
        		answer = new char[lenb + 1];
        		answer[0] = '1';
        		for(i = lenb; i > 0; i--)
        		{
        			answer[i] = temp[i - 1];
        		}
        		return String.valueOf(answer);
        	}
        	else
        		return String.valueOf(temp);
        	//return String.valueOf(answer);
        }
        //a长度较长
        else
        {
        	temp = new char[lena];
        	int i,j;
        	for(i = lenb - 1, j = lena - 1; i >= 0; i--,j--)
        	{
        		temp[j] = (char) ('0' + ((strb[i] - '0' + stra[j] - '0' + c) % 2));
        		c = (strb[i] - '0' + stra[j] - '0' + c) / 2;
        	}
        	//短数已经算完但仍有进位需要处理
        	if(c == 1)
        	{
        		for(; j >= 0; j--)
        		{
        			temp[j] = (char) ('0' + ((stra[j] - '0' + c) % 2));
            		c = (stra[j] - '0' + c) / 2;
        		}
        	}
        	//短数已经算完无进位需要处理
        	else
        	{
        		for(; j >= 0; j--)
        		{
        			temp[j] = stra[j];
        		}
        	}
        	//结果数组不够存储，需要扩充位数
        	if(c == 1)
        	{
        		answer = new char[lena + 1];
        		answer[0] = '1';
        		for(i = lena; i > 0; i--)
        		{
        			answer[i] = temp[i - 1];
        		}
        		return String.valueOf(answer);
        	}
        	else
        		return String.valueOf(temp);
        }
    }
}