package WeBank_2020_Spring;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();// 兽
		long k = sc.nextInt();// 技能
		long m = sc.nextInt();// 闲先知
		long res = 0;
		if (m <= n) {
			res = (n * k + m - 1) / m;
		}else {
			res = k;
		}
		System.out.println(res);
	}

}
