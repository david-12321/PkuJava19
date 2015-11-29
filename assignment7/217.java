import java.util.HashSet;

public class ContainsDuplicate
{

	public static void main(String[] args)
	{
		ContainsDuplicate cd = new  ContainsDuplicate();
		int[] nums={1,2};
		System.out.println(cd.containsDuplicate(nums));
	}

    public boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<nums.length;i++)
    	{
    		if(set.contains(nums[i]))
    		{
    			return true;
    		}
    		else {
				set.add(nums[i]);
			}
    	}
        return false;
    }
}
