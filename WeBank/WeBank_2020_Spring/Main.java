package WeBank_2020_Spring;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==1) {
			System.out.println();
			System.out.println("1");
			return;
		}
		int m = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int s = 0;
		while (list.size() > 1) {
			s = (s + m - 1)% list.size();
			System.out.print(list.remove( s ));			
			if (list.size() != 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
		System.out.println(list.get(0));
	}

}
