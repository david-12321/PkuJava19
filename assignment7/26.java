public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        int length = 1;
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] != nums[length-1])
            {
                length++;
                nums[length-1] = nums[i];
            }
        }
        return length;
    }
}