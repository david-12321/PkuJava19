public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int total = 1;
        for(int i = 1; i < length; i++)
        {
        	if(nums[i] == nums[i - 1])
        		continue;
        	else
        	{
        		//total++;
        		nums[total] = nums[i];
        		total++;
        	}
        }
        return total;
    }