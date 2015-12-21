public int trailingZeroes(int n) {
		//int multiple = 5;
		long multiple = 5;
		int count = 0;
		//while(multiple < n)
		while(multiple <= n)
		{
			count += n / multiple;
			multiple *= 5;
		}
		return count;
    }