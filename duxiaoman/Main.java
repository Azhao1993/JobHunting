package duxiaoman;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			long temp = sc.nextLong();
			String str1 = sloution(temp);
		}
	}
	private static String sloution(long temp) {
		if(temp<10) {			
			return "G";
		}		
		long n = temp;
		int count = 0;		
		while(n>0) {
			long num = n%10;
			if(num==0) {
				count++;
				continue;
			}else {
				long chu == temp/num;
				if(chu*num==temp) {
					count++;		
				}				
			}
			n /= 10;				
		}
		if(count==String)
		
		
		
	}
}
