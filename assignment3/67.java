public class Solution {
    public String addBinary(String a, String b) {
        char c[] = a.toCharArray();
		char d[] = b.toCharArray();
		
		if(c.length < d.length)
		{
			char temp[] = c;
			c = d;
			d = temp;
		}
		
		char result[] = new char[c.length+1];
		
		for(int i=0; i<c.length; i++){
			result[i+1] = c[i];
		}
		
		int count = 0; //计数用
		
		for(int i=c.length-1; i>=c.length-d.length; i--){
			count ++;
			if(result[i+1] == '0' && d[d.length-count] == '0')
			{
				result[i+1] = '0';
			}
			else if(result[i+1] == '1' && d[d.length-count] == '0')
			{
				result[i+1] = '1';
			}
			else if(result[i+1] == '0' && d[d.length-count] == '1')
			{
				result[i+1] = '1';
			}
			else if(result[i+1] == '1' && d[d.length-count] == '1')
			{
				result[i+1] = '0';
				int j;
				for(j = i-1; j>=0; j--)
				{
					if(c[j] == '1')
					{
						result[j+1] = '0';
					}
					else
						{
							result[j+1] = '1';
							break;
						}	
				}	
				if(j == -1){
						result[0] = '1';
					}
			}
		}
		return String.valueOf(result).trim();
    }
}