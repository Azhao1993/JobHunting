package ByteDance_2019_BackgroundDevlopment_1;

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

}
