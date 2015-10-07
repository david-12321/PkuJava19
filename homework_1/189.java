public class Solution {
    public void rotate(int[] nums, int k) {
        /*if(!(k > nums.length))
        {
            reverse(nums, k);
            //reverse(nums + k, nums.length - k);
            //reverse(nums, nums.length);
            reverse(nums, nums.length);
            reverse(nums, nums.length - k);
        }*/
        /*
        reverse(nums, k%nums.length);
        reverse(nums, nums.length);
        reverse(nums, nums.length - k%nums.length);
        */
        /*
        reverse(nums, nums.length - k%nums.length);
        reverse(nums, nums.length);
        reverse(nums, k%nums.length);
        */
        int len = nums.length;
        reverse(nums, len - k%len);
        reverse(nums, len);
        reverse(nums, k%len);
        
    }
    
    public void reverse(int[] nums, int size) {
        int temp;
        for(int i = 0; i < size/2; i++)
        {
            temp = nums[i];
            nums[i] = nums[size - i - 1];
            nums[size - i - 1] = temp;
        }
    }
}