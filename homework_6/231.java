public boolean isPowerOfTwo(int n) {
        if(n < 0)
            return false;
        char[] s = Integer.toBinaryString(n).toCharArray();
        //if(s[0] == '1')
        //if(s.length > 1 && s[0] == '1')
        //   return false;
        int length = s.length;
        int count = 0;
        for(int i = 0; i < length; i++)
        {
        	if(s[i] == '1')
        		count++;
        }
        if(count == 1)
        	return true;
        else
        	return false;
    }