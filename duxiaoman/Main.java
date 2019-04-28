package duxiaoman;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			long temp = sc.nextLong();
			sloution(temp);
		}
	}

	private static void sloution(long temp) {
		if(temp<10) {
			System.out.println("G");
			return;
		}
		boolean flag = false;
		long n = temp;
		while(n>0) {
			long num = n%10;
			n /= 10;
			if(num==0) {
				flag = true;
				continue;
			}
			if(temp%num==0) {
				flag = true;				
			}else if(flag){
				System.out.println("H");
				return;
			}			
		}
		if(!flag) {
			System.out.println("S");
		}else {
			System.out.println("G");
		}
		
		
	}
}
