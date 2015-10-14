public class Solution {
    public int addDigits(int num) {
        int root = 0;
        if(num == 0)
            return root;
        else if(num % 9 == 0)
            root = 9;
        else
            root = num % 9;
        return root;
    }
}