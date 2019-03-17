package ByteDance_2019_BackgroundDevelopment_1;

import java.util.Scanner;

/*
	��һ��:
		ĳ������ϵͳ������ֵ1Ԫ��4Ԫ��16Ԫ��64Ԫ����4��Ӳ�ң��Լ���ֵ1024Ԫ��ֽ�ҡ�
		����ĳ��ʹ��1024Ԫ��ֽ�ҹ�����һ���۸�ΪN(0��N��1024)����Ʒ��
		�������������յ�����Ӳ��?
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
	//ţ��
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
