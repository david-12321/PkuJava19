
//leetcode 88
public class MergeSortedArray
{

	public static void main(String[] args)
	{

	}
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0)
    	{
        	nums1 = nums2;
        	return;
    	}
        if(n==0)
        	return;
        int i=m-1;
        int j=n-1;
        int id = m+n-1;
        while(i>=0&&j>=0)
        {
        	if(nums1[i]>=nums2[j])
        	{
        		nums1[id--] = nums1[i--];
        	}
        	else {
        		nums1[id--] = nums2[j--];
			}
        }
//        while(i>=0)
//        	nums1[id--] = nums1[i--];
        while(j>=0)
        	nums1[id--] = nums2[j--];
    }
}
