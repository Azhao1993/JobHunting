package ByteDance_2017_BackgroundDevelopment;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		for(int i = 0;i<n;i++) {
			int count = 0;
			String temp = sc.next();
			StringBuilder sb = new StringBuilder(temp);
			for(int x = 0;x<temp.length();x++ ) {
				char ch = sb.charAt(temp.length()-1);
				sb.deleteCharAt(temp.length()-1);
				sb.insert(0, ch);
				if(sb.toString().equals(temp)) {
					count++;
				}
			}
			if(count==k) {
				result++;
			}
		}
		System.out.println(result);
	}
}
