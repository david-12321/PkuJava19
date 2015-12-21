public static int countPrimes(int n) {
		/*
        int count = 0;
        for(int i = 2; i < n; i++)
        {
        	int j;
        	//for(j = 2; j < i; j++)
        	for(j = 2; j * j <= i; j++)
        	{
        		if(i % j == 0)
        			break;
        	}
        	//if(j == i)
        	if(j * j > i)
        		count ++;
        }
        return count;
        */
		int count = 0;
		//boolean number[] = new boolean[n + 1];
		boolean number[] = new boolean[n];
		//for(int i = 2; i <= n; i++)
		for(int i = 2; i < n; i++)
		{
			if(number[i] == false)
			{
				count++;
				//int j = i;
				//for(int k = 1; k * j <= n;k++)
				for(int k = 1; k * i < n;k++)
				{
					//j = j * k;
					//number[j] = true;
					number[k * i] = true;
				}
			}
			else
				continue;
		}
		return count;
    }