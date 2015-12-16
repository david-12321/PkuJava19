public class Solution {
    public int trailingZeroes(int n) {
        // int result = 1;
        // int count = 0;
        // for(int i=n; i>0; i--)
        // {
        //     result = result * n;
        //     n = n-1;
        // }
        
        // while(result % 10 == 0)
        // {
        //     count ++;
        //     result = result / 10;
        // }
        // return count;
        //以上时间超时
        //考虑n!的质因子，2*5尾数才会出现0，且2的个数一定多于5的个数，故考察质因子5的个数即可得到0的个数
        int count = 0;
        while(n != 0)
        {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}