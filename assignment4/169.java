
public class MajorityElement
{

	public static void main(String[] args)
	{
		int[] nums={1,2,3,1,1,1,7,9,1,1};
		System.out.println(new MajorityElement().findByCount(nums));
	}

	public int findByCount(int[] nums)
	{
		int count=0;
		int result=0;
		
		for(int i=0;i<nums.length;i++)
		{
			if(count==0)
			{
				result=nums[i];
				count++;
			}
			else 
			{
				if(result==nums[i])
				{
					count++;
				}
				else 
				{
					count--;
				}
			}
		}
		
		return result;
	}
	
	public int findByDivideConquer(int[] nums)
	{
		return 0;
	}
}
