package HappyNumber_202;

import java.util.HashSet;

public class HappyNumber_202 {
	public static void main(String[] args) {
		int n = 18;
		boolean b = isHappy(n);
		System.out.println(b);
	}
	
	public static boolean isHappy(int n){
		int m = 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(!set.contains(n)){
			set.add(n);
			m = 0;
			while(n != 0){
				m += (n % 10) * (n % 10);
				n /= 10;
			}
			n = m;
			
			if(n == 1)
				return true;
		}
		return false;
	}
}
