import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{

	public static void main(String[] args)
	{
		int[] nums={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		new ThreeSum().threeSum(nums);
	}

	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		int len = nums.length;

		for (int begin = 0; begin < len; begin++)
		{
			if(begin>0 && nums[begin]==nums[begin-1])
				continue;
			int end = len - 1;
			while (begin < end)
			{
				int target = 0 - nums[begin] - nums[end];

				int low = begin + 1;
				int high = end - 1;
				while (low <= high)
				{
					int middle = (low + high) / 2;
					if (target == nums[middle])
					{
						List<Integer> listTemp = new ArrayList<Integer>();
						listTemp.add(nums[begin]);
						listTemp.add(target);
						listTemp.add(nums[end]);
						list.add(listTemp);
						break;
					} else if (target < nums[middle])
					{
						high = middle - 1;
					} else
					{
						low = middle + 1;
					}
				}

				while (begin < end && nums[end-1] == nums[end])
					end--;
				end--;
			}
		}

		return list;
	}
}
