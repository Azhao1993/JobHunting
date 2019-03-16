package ByteDance_2019_BackgroundDevlopment_1;

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

}
