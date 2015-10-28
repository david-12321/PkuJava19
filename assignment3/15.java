public class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(nums == null || nums.length < 3) return list;

		Arrays.sort(nums);
		
		for(int a=0; a<nums.length-2; a++)
		{
			if(a>0 && nums[a] == nums[a-1]) continue;
			int b = a+1;
			int c = nums.length-1;
			while(b < c)
			{	
				if(nums[b]+nums[c]+nums[a] == 0)
				{
					List<Integer> list1 = new ArrayList<Integer>();
					list1.add(nums[a]);
					list1.add(nums[b]);
					list1.add(nums[c]);
					list.add(list1);
					while(b < c && nums[b] == nums[b+1])
						b++;
					while(b < c && nums[c] == nums[c-1])
						c--;
					b++;
					c--;
				}
				else if(nums[b] + nums[c] + nums[a] > 0)
				{
					c--;
				}
				else if(nums[b] + nums[c] + nums[a] < 0)
				{
					b++;
				}
			}
		}
		return list;
    }
}