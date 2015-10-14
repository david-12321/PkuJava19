public int reverse(int x) {
        //int answer = 0;
		long answer = 0;
        int flag,num;
        if(x == Math.abs(x))
        	flag = 1;
        else
        	flag = -1;
        x = Math.abs(x);
        while(x > 0)
        {
        	answer =  answer * 10;
        	num = x % 10;
        	x = x / 10;
        	answer = answer + num;
        }
        if((answer * flag) > Integer.MAX_VALUE || (answer * flag) < Integer.MIN_VALUE)
        	return 0;
        else
        	return (int)answer * flag;
    }