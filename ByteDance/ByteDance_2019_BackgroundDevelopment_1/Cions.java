package ByteDance_2019_BackgroundDevelopment_1;

import java.util.Scanner;

/*
	第一题:
		某国货币系统包含面值1元，4元，16元，64元共计4钟硬币，以及面值1024元的纸币。
		现在某人使用1024元的纸币购买了一件价格为N(0≤N≤1024)的商品。
		请问最少他会收到多少硬币?
 */
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
	//牛客
	public static void main0(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result64 = 0;
		int result16 = 0;
		int result4 = 0;
		int total = 0;
		N = 1024 - N;
		while (N > 64) {
			result64 += N >> 6;
			N -= result64 * 64;
		}
		while (N > 16) {
			result16 += N >> 4;
			N -= result16 * 16;
		}
		while (N > 4) {
			result4 += N >> 2;
			N -= result4 * 4;
		}
		total = result64 + result16 + result4 + N;
		System.out.println(total);
	}

}
