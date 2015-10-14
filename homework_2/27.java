public int removeElement(int[] nums, int val) {
        int length = nums.length;
        /*
        int count = 0;
        for(int i = 0; i< length; i++)
        {
        	if(nums[i] == val)
        		count++;
        }
        int[] answer = new int[length - count];
        int position = 0;
        for(int i = 0; i < length; i++)
        {
        	if(nums[i] != val)
        		answer[position++] = nums[i];
        }
        nums = answer;
        return length - count;
        */
        int i = 0;
        while(i < length)
        {
        	if(nums[i] != val)
        	{
        		i++;
        	}
        	else
        	{
        		nums[i] = nums[length - 1];
        		length--;
        	}
        }
        return length;
    }