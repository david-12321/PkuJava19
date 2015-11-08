import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum
{

	public static void main(String[] args)
	{
		int[] nums={1,0, -1, 0, -2, 2};
		new FourSum().fourSum(nums,0);
	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		int len = nums.length;

		for (int begin = 0; begin < len; begin++)
		{
			if(begin>0 && nums[begin]==nums[begin-1])
				continue;
			int end = len - 1;
			while (begin < end-2)
			{
				int subTarget = target - nums[begin] - nums[end];
				
				int low = begin + 1;
				int high = end - 1;
				while (low < high)
				{
					int sum = nums[low]+nums[high];
					if(sum==subTarget)
					{
						list.add(Arrays.asList(nums[begin],nums[low],nums[high],nums[end]));
						while(low<high&&nums[low]==nums[low+1]) low++;
						while(low<high&&nums[high]==nums[high-1]) high--;
						low++;
						high--;
					}
					else if(sum>subTarget)
						high--;
					else
						low++;
				}

				while (begin < end-2 && nums[end-1] == nums[end])
					end--;
				end--;
			}
		}

		return list;
    }
}
