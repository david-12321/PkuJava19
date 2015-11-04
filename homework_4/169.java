public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = nums.length;
        for(int i = 0; i < length; i++)
        {
        	if(stack.isEmpty())
        		stack.push(nums[i]);
        	else if(nums[i] == stack.peek())
        		stack.push(nums[i]);
        	else
        		stack.pop();
        }
        return stack.pop();
    }