public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map =  new HashMap<Integer,Integer>();
        int length = nums.length;
        int[] answer = new int[2];
        for(int i = 0; i < length; i++)
        {
        	if(!map.containsKey(nums[i]))
        		map.put(target - nums[i], i);
        	else
        	{
        		answer[0] = (int)map.get(nums[i]) + 1;
        		answer[1] = i + 1;
        		break;
        	}
        }
        return answer;
    }