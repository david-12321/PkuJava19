public int singleNumber(int[] nums) {
        int answer = 0;
        int length = nums.length;
        for(int i = 0; i < length;i++)
        {
        	answer  = answer ^ nums[i];
        }
        return answer;
    }