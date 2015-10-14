public int addDigits(int num) {
        int count = num;
        while( !(count / 10 == 0))
        {
        	count = 0;
        	while(num > 0)
        	{
        		count += num % 10;
        		num = num / 10;
        	}
        	num = count;
        }
        return count;
    }