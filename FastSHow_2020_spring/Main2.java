package FastSHow_2020_spring;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// System.out.println(10000000 < Integer.MAX_VALUE);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long res = 1;
		//int twoCount = 0;
		for(int i =2;i<=n;i++) {
			res *=i;
			while(res%10==0) {
				res/=10;
			}
			res%=1000000000;
		}
		while(res%10==0) {
			res/=10;
		}
		System.out.println(res%10);

	}

}
