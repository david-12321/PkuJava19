public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> newlist;
        int length = nums.length;
        int a,b,twosum;
        Arrays.sort(nums);
        for(int i = 0; i < length; i++)
        {
        	for(int j = i + 1; j < length; j++)
        	{
        		a = nums[i];
        		b = nums[j];
        		twosum = target - a - b;
        		int left = j + 1;
        		int right = length - 1;
        		while(left < right)
    			{
    				if(nums[left] + nums[right] == twosum)
    				{
    					newlist = new ArrayList<Integer>();
    					newlist.add(a);
    					newlist.add(b);
    					newlist.add(nums[left]);
    					newlist.add(nums[right]);
    					answer.add(newlist);
    					if(nums[left] == nums[right])
    						break;
    					else
    					{
    						while(left + 1 < length && nums[left] == nums[left + 1])
    							left++;
    						while(right - 1 > i && nums[right] == nums[right - 1])
    							right--;
    					}
    					left++;
    					right--;
    				}
    				else if(nums[left] + nums[right] > twosum)
    					right--;
    				else
    					left++;
    				
    			}
    			while(j + 1 < length && nums[j] == nums[j + 1])
    				j++;
        	}
        	while(i + 1 < length && nums[i] == nums[i + 1])
				i++;
        }
        return answer;
    
    }