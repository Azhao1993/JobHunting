package FastSHow_2020_spring;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// System.out.println(10000000 < Integer.MAX_VALUE);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[10007];
		int sum = 1;
		int count = 0;
		for (int i = 1; i <= N; i++) {
			a[i] = i;
		}
		for (int i = 5; i <= N; i += 5) {

			while (a[i] % 5 == 0) {
				a[i] /= 5;
				count++;
			}

		}
		for (int i = 2; i / 2 <= count; i += 2) {
			a[i] /= 2;
		}
		for (int i = 2; i < N; i++) {
			sum *= a[i];
			while (sum % 10 == 0) {
				sum /= 10;
			}
			sum %= 10;
		}
		System.out.println(sum);

	}

}
