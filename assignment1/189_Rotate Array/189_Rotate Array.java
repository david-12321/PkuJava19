package RotateArray_189;

public class RotateArray_189 {
	public static void main(String[] args){
		int [] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]);
		}
	}
	
	public static void rotate(int[] nums, int k){	
//		while(k>0){
//			int temp = nums[nums.length - 1];
//			for(int i=nums.length-2; i>=0; i--){
//				nums[i+1] = nums[i];
//			}
//			nums[0] = temp;
//			k--;
//		}
//	以上算法在数组过大时超时
		if(k == 0)
			return;
		
		if(nums.length == 1)
			return;

		k = k % nums.length;
		
		reversal(nums, 0, nums.length-1-k);
		reversal(nums, nums.length-k, nums.length-1);
		reversal(nums, 0, nums.length-1);
	}
	public static void reversal(int [] nums, int s, int e){
		while(s<e){
			int temp = nums[s];
			nums[s] = nums[e];
			nums[e] = temp;
			s++;
			e--;
		}
	}
}
