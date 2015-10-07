package LengthOfLastWord;

public class LengthOfLastWord {
	public static void main(String[] args){
		String s = "Hello World e   ";
		int n = lengthOfLastWord(s);
		System.out.println(n);
	}
	
	public static int lengthOfLastWord(String s){
		int count = 0;
		char k[] = s.toCharArray();
		for(int i=0; i<k.length; i++){
			if(k[i] != ' ')
				count++;
			else
			{
				if(i == k.length-1)
					break;
				else if(k[i+1] != ' ')
					count = 0;
			}
		}
		return count;
	}
}
