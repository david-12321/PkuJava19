public String intToRoman(int num) {
        /*
        StringBuilder answer = new StringBuilder();
        if(num >= 1000)
        {
        	for(int i = 0; i < num/1000; i++)
        		string.append('M');
        	num = num - num/1000*1000;
        }
        if(num >= 900)
        {
        	string.append("CM");
        	num = num - 900;
        }
        if(num >= 500)
        {
        	string.append('C');
        	num = num - 500;
        }
        if(num >= 400)
        {
        	string.append("CD");
        	num = num - 400;
        }
        if(num >= 100)
        {
        	for(int i = 0; i < num/100; i++)
        		string.append('C');
        	num = num - num/100*100;
        }
        */
		StringBuilder answer = new StringBuilder();
		int value[] = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String roman[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int length = value.length;
		for(int i = 0; i < length; i++)
		{
			if(num >= value[i])
				for(int j = 0; j < num/value[i]; j++)
					answer.append(roman[i]);
			num = num - num/value[i]*value[i];
		}
		return answer.toString();
    }