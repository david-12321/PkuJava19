public class Solution {
    public boolean isPowerOfTwo(int n) {
        // if(n==1 || n==2)
        //     return true;
            
        // int t = 2;
        
        // for(int i=2; i<=30; i++)
        // {
        //     t = t * 2;
        //     if(n == t)
        //         return true;
        // }
        // return false;
        if(n>0  && (n & (n-1)) == 0)
            return true;
        else
            return false;
    }
}