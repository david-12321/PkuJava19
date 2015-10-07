public class Solution {
    public int myAtoi(String str) {
        if(str.trim().length() == 0)
			return 0;
        char[] temp = str.trim().toCharArray();
        int length = temp.length;
        //if((temp[0] == '-') || (temp[0] == '+'))
        if(temp[0] == '+')
        {
        	int i = 1;
        	long sum = 0;
        	//while((temp[i] > '0') || (temp[i] < '9'))
        	//while((i < length) && ((temp[i] >= '0') || (temp[i] <= '9')))
        	while((i < length) && (temp[i] >= '0') && (temp[i] <= '9'))
        	{
        		sum = sum * 10;
        		//sum += temp[i];
        		sum = sum + temp[i] - '0';
        		i++;
        	}
        	if(i == 1)
        		return 0;
        	//if((sum > 2147483647) || (sum < -2147483648))
        	//	return 2147483647;
        	/*
        	if(sum > 2147483647)
        		return 2147483647;
        	else if(sum < -2147483648)
        		return -2147483648;
        	*/
        	//if(i > 13)
        	if((sum > 2147483647) || (i > 13))
        		return 2147483647;
        	else
        		return (int)sum;
        }
        else if(temp[0] == '-')
        {
        	int i = 1;
        	long sum = 0;
        	//while((temp[i] > '0') || (temp[i] < '9'))
        	//while((i < length) && ((temp[i] >= '0') || (temp[i] <= '9')))
        	while((i < length) && (temp[i] >= '0') && (temp[i] <= '9'))
        	{
        		sum = sum * 10;
        		//sum += temp[i];
        		sum = sum + temp[i] - '0';
        		i++;
        	}
        	if(i == 1)
        		return 0;
        	sum = sum * (-1);
        	//if((sum > 2147483647) || (sum < -2147483648))
        	//	return 2147483647;
        	/*
        	if(sum > 2147483647)
        		return 2147483647;
        	else if(sum < -2147483648)
        		return -2147483648;
        	*/
        	//if(i > 13)
        	if((sum < -2147483648) || (i > 13))
        		return -2147483648;
        	else
        		return (int)sum;
        }
        /*
        for(int i = 0; i < length; i++)
        {
        	if((temp[i] == '-') || (temp[i] == '+'))
        }
        */
        else
        {
        	int i = 0;
        	long sum = 0;
        	//while((temp[i] > '0') || (temp[i] < '9'))
        	//while((i < length) && ((temp[i] >= '0') || (temp[i] <= '9')))
        	while((i < length) && (temp[i] >= '0') && (temp[i] <= '9'))
        	{
        		sum = sum * 10;
        		//sum += temp[i];
        		sum = sum + temp[i] - '0';
        		i++;
        	}
        	if(i == 0)
        		return 0;
        	//if((sum > 2147483647) || (sum < -2147483648))
        	//	return 2147483647;
        	/*
        	if(sum > 2147483647)
        		return 2147483647;
        	else if(sum < -2147483648)
        		return -2147483648;
        	*/
        	//if(i > 12)
        	if((sum > 2147483647) || (i > 12))
        		return 2147483647;
        	else
        		return (int)sum;
        }
    }
}