
public class RmvDupFromArrary
{

	public static void main(String[] args)
	{
		int[] nums={1,1,1,2,2,2,3,3,3,3,3,3,3,3,3,4,5,6,6};
		int n = new RmvDupFromArrary().removeDuplicates(nums);
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[i]);
		}
	}

    public int removeDuplicates(int[] nums) 
    {
    	if(nums.length<=1)
    		return nums.length;
    	
        int low=1;
        
        for(int i=1;i<nums.length;i++)
        {
        	if(nums[i]!=nums[i-1])
        	{
        		nums[low]=nums[i];
        		low++;	
        	}
        }
        
        return low;
    }
}
