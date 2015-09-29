
public class SortColors
{

	public static void main(String[] args)
	{
		int[] nums = {1};	
		new SortColors().sortColors(nums);
	}
	
	public void sortColors(int[] nums)
	{
		if(nums.length<=1)
			return;
		
		int start = 0;
		int end = nums.length-1; 
		int tempIndex=0;
		int tempColor=-1;
//		while(start<=end)
//		{
		while(start<=end&&nums[start]==0) start++;
		while(start<=end&&nums[end]==2) end--;
		tempIndex = start;
		while(start<=end)
		{
			while(tempIndex<=end&&nums[tempIndex]==1) tempIndex++;
			if(tempIndex>end)
			{
				break;
			}
			if(nums[tempIndex]==2)
			{
				tempColor=nums[end];
				//nums[end]=2;
				nums[end]=nums[tempIndex];
				nums[tempIndex]=tempColor;
				end--;
			}
			else if(nums[tempIndex]==0)
			{
				
				tempColor=nums[start];
				//nums[start]=0;
				nums[start]=nums[tempIndex];
				nums[tempIndex]=tempColor;
				start++;
			}
			if(tempIndex<start)
			{
				tempIndex=start;
			}
		}
		
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]);
		}
	}
}
