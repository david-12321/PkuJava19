public class Solution {
    public int climbStairs(int n) {
		if(n == 1 || n == 2 || n == 0)
			return n;
		else
		{
			int step[] = new int [n+1];
			step[1] = 1;
			step[2] = 2;
			for(int i = 3; i <= n; i++){
				step[i] = step[i-1] + step[i-2];
			}
			return step[n];
		}
    }
}