package WeBank_2020_Spring;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//int[] n = new int[T];
		for(int i = 0;i<T;i++) {
			int temp = sc.nextInt();
			int res = sloution(temp);
			System.out.println(res);
		}
	}

	private static int sloution(int temp) {
		int result = 0;
		if(temp==1) {
			return result;			
		}
		while(temp !=1) {
			result++;
			if(temp%2==0) {
				temp /=2;
			}else {
				temp = 3*temp+1;
			}
		}
		return result;
		
	}
}
