public class Solution {
    public void sortColors(int[] nums) {
        int count[] = new int[3];
        int length = nums.length;
        //统计0,1,2的个数
        for(int i = 0; i < length; i++)
        {
        	count[nums[i]]++;
        }
        int position = 0;
        //对数组重新赋值
        while(count[0] > 0)
        {
        	nums[position++] = 0;
        	count[0]--;
        }
        while(count[1] > 0)
        {
        	nums[position++] = 1;
        	count[1]--;
        }
        while(count[2] > 0)
        {
        	nums[position++] = 2;
        	count[2]--;
        }
    }
}