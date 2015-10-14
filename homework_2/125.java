public boolean isPalindrome(String s) {
        if(s.trim().equals(""))
			return true;
        StringBuilder string = new StringBuilder();
        char[] x = s.toCharArray();
        int length = x.length;
        int j;
        for(int i = 0; i < length; i++)
        {
        	if(x[i] >= 'a' && x[i] <='z')
        		string.append(x[i]);
        	else if(x[i] >='A' && x[i] <='Z')
        		//string.append((x[i] + 32));
        		string.append((char)(x[i] + 32));
        	else if(x[i] >= '0' && x[i] <= '9')
        		string.append(x[i]);
        }
        char[] word = string.toString().toCharArray();
        int len_word = word.length;
        //for(int i = 0; i < len_word/2; i++)
        for(j = 0; j < len_word/2; j++)
        {
        	if(word[j] == word[len_word - 1 - j])
        		continue;
        	else
        		break;
        }
        if(j == len_word/2)
        	return true;
        else
        	return false;
    }