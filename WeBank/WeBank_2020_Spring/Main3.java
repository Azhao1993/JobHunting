package WeBank_2020_Spring;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();// ��
		long k = sc.nextInt();// ����
		long m = sc.nextInt();// ����֪
		long res = 0;
		if (m <= n) {
			res = (n * k + m - 1) / m;
		}else {
			res = k;
		}
		System.out.println(res);
	}

}
