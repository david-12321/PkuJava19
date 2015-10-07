package NumberOfOneBits;

public class NumberOfOneBits {
	public static void main(String[] args){
		int n = 11;
		int m = hammingWeight(n);
		System.out.println(m);
	}
	
	public static int hammingWeight(int n){
		String str = Integer.toBinaryString(n);
		char k[] = str.toCharArray();
		int count = 0;
		
		for(int i=0; i<k.length; i++){
			if(k[i] == '1')
				count++;
		}
		return count;
	}
}