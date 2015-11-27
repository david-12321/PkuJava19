public class Solution {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int number = 0;
        int t = 0;
        // number = number + (c[c.length-1] - 'A' + 1);
        for(int i=c.length-1; i>=0; i--)
        {
            t = (c[i] - 'A' + 1);
            for(int j=i; j<c.length-1; j++)
            {
                t = t * 26;
            }
            number = number + t;
        }
        return number;
    }
}