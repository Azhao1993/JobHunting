package ByteDance_2019_houduan;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i<n;i++) {
			int num = sc.nextInt();//��������
			int[] a = new int[num];//����
			for(int j = 0;j<num;j++) {
				a[i]= sc.nextInt();
			}
			sloution(num,a);
		}
		
	}

	private static void sloution(int num, int[] a) {
		if(num<=1) {
			System.out.println(num);
			return;
		}
		//����<=2
		if(num==2) {
			System.out.println(num);
			return;
		}
		//����������
		
	}
}
