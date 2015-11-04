public int climbStairs(int n) {
        int[] x = new int[]{1,2,3};
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		else
		{
			for(int i = 0; i < n - 3; i++)
			{
				x[0] = x[1];
				x[1] = x[2];
				x[2] = x[0] + x[1];
			}
			return x[2];
		}
    }