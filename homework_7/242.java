public boolean isAnagram(String s, String t) {
        char[] str_s = s.toCharArray();
        char[] str_t = t.toCharArray();
        int len_s = str_s.length;
        int len_t = str_t.length;
        int[] count = new int[26];
        int i;
        for(i = 0; i < len_s; i++)
        	count[str_s[i] - 'a']++;
        for(i = 0; i< len_t; i++)
        	count[str_t[i] - 'a']--;
        for(i = 0; i < 26; i++)
        {
        	if(count[i] != 0)
        		break;
        }
        if(i == 26)
        	return true;
        else
        	return false;
    }