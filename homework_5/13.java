public int romanToInt(String s) {
        int value[] = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String roman[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int total = 0;
		char[] string = s.toCharArray();
		int j = 0;
		for(int i = 0; i < roman.length; i++)
		{
			for(; j < string.length; j++)
			{
				String temp1 = "" + string[j];
				String temp2 = null;
				if(j != string.length - 1)
					temp2 = "" + string[j] + string[j + 1];
				//if(temp1.equals(roman[i]) || temp2.equals(roman[i]))
				if(temp1.equals(roman[i]) || ((j != string.length - 1) && temp2.equals(roman[i])))
				{
					total = total + value[i];
					if((j != string.length - 1) && temp2.equals(roman[i]))
						j++;
				}
				else
					break;
			}
		}
		return total;
    }