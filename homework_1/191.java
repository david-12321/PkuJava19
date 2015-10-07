public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int number = 0;
        /*
        while(n > 0)
        {
        	number += n % 2;
        	n = n / 2;
        }
        */
        for(int i = 0; i < 32; i++)
        {
            //通过与操作获取最低位的数字
        	number += n & 1;
        	n = n >> 1;
        }
        return number;
    }
}