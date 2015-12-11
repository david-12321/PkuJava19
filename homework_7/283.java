public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i,position;
        for(i = 0,position = 0; i < length; i++)
        {
        	if(nums[i] != 0)
        	{
        		nums[position++] = nums[i];
        	}
        }
        while(position < length)
        	nums[position++] = 0;
    }