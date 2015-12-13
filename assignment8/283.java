// leetcode 283
public class MoveZeroes
{

	public static void main(String[] args)
	{
		int[] nums = {0,2,0,12,0,2,0};
		new MoveZeroes().moveZeroes(nums);
		for(int n : nums){
			System.out.print(n+" ");
		}
	}

    public void moveZeroes(int[] nums) {
        if(nums.length == 0)
        	return;
        int nonZeroIndex = 0;
        for(int n:nums)
        {
        	if(n!=0)
        	{
        		nums[nonZeroIndex++] = n;
        	}
        }
        
        for(int i= nonZeroIndex;i<nums.length;i++)
        	nums[i]=0;
    }
}
