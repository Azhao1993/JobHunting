package ByteDance_2019_houduan;

import java.util.Scanner;

public class Cions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		N = 1024 - N;
		if (N >= 64) {
			result += N / 64;
			N %= 64;
		}
		if (N >= 16) {
			result += N / 16;
			N %= 16;
		}
		if (N >= 4) {
			result += N / 4;
			N %= 4;
		}
		if (N >= 1) {
			result += N / 1;
			N %= 1;
		}
		System.out.println(result);

	}

}
