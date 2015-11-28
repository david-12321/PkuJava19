public int titleToNumber(String s) {
        char[] string = s.toCharArray();
        int length = string.length;
        int multiple = 1;
        int answer = 0;
        for(int i = length - 1; i >= 0; i--)
        {
        	answer = answer + multiple * (string[i] - 'A' + 1);
        	multiple = multiple * 26;
        }
        return answer;
    }