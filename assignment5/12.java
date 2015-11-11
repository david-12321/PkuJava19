public class Solution {
    public String intToRoman(int num) {
    	String out = null;
    	char[] result = new char[20];
//    	String[] roman = {"I","V","X","L","C","D","M"};
    	
    	int count = 0;
    	int thousand = num / 1000;
    	int hundred = (num % 1000) / 100;
    	int decade = (num % 100) / 10;
    	int digit = num % 10;
    	while(thousand != 0)
    	{
    		result[count] = 'M';
    		count ++;
    		thousand --;		
    	}
    	if(hundred != 0){
    	switch(hundred){
    		case 1 : 
    			result[count] = 'C';
    			count ++;
    			break;
    		case 2 :
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			break;
    		case 3 : 
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			break;
    		case 4 :
    			result[count] = 'C';
    			count ++;
    			result[count] = 'D';
    			count ++;
    			break;
    		case 5 : 
    			result[count] = 'D';
    			count ++;
    			break;	
    		case 6 :
    			result[count] = 'D';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			break;
    		case 7 :
    			result[count] = 'D';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			break;
     		case 8 :
    			result[count] = 'D';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			result[count] = 'C';
    			count ++;
    			break;
     		case 9 :
    			result[count] = 'C';
    			count ++;
    			result[count] = 'M';
    			count ++;
    			break;
    		}	
    	}
    	if(decade != 0){
    	switch(decade){
    	case 1 : 
			result[count] = 'X';
			count ++;
			break;
		case 2 :
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			break;
		case 3 : 
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			break;
		case 4 :
			result[count] = 'X';
			count ++;
			result[count] = 'L';
			count ++;
			break;
		case 5 : 
			result[count] = 'L';
			count ++;
			break;	
		case 6 :
			result[count] = 'L';
			count ++;
			result[count] = 'X';
			count ++;
			break;
		case 7 :
			result[count] = 'L';
			count ++;
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			break;
 		case 8 :
			result[count] = 'L';
			count ++;
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			result[count] = 'X';
			count ++;
			break;
 		case 9 :
			result[count] = 'X';
			count ++;
			result[count] = 'C';
			count ++;
			break;
    	}
    }
    	switch(digit){
		case 1 : 
			result[count] = 'I';
			count ++;
			break;
		case 2 :
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			break;
		case 3 : 
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			break;
		case 4 :
			result[count] = 'I';
			count ++;
			result[count] = 'V';
			count ++;
			break;
		case 5 : 
			result[count] = 'V';
			count ++;
			break;	
		case 6 :
			result[count] = 'V';
			count ++;
			result[count] = 'I';
			count ++;
			break;
		case 7 :
			result[count] = 'V';
			count ++;
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			break;
 		case 8 :
			result[count] = 'V';
			count ++;
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			result[count] = 'I';
			count ++;
			break;
 		case 9 :
			result[count] = 'I';
			count ++;
			result[count] = 'X';
			count ++;
			break;
    	}
    	out = String.valueOf(result).trim();
		return out;
    }
}