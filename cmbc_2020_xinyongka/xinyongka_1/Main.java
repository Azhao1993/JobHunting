package xinyongka_1;

import java.util.Scanner;

public class Main {
	//分巧克力
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long res = 0;
		int mod = 666666666;
		if (n >= 6) {
			res = 1;
			// 计算快速幂
			// res = (int)pow(2,n-6) % mod;
			int num = n - 6;
			long tem = 2;
			while (num != 0) {
				if ((num & 1) != 0) {
					res = res * tem % mod;
				}					
				tem *= tem;
				num = num >> 1;
			}
		}
		System.out.println(res);
	}

}
