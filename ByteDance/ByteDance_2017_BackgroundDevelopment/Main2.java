package ByteDance_2017_BackgroundDevelopment;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int n = sc.nextInt();
		for (int x = 0; x < n; x++) {
			int i = sc.nextInt();
			Integer length = sc.nextInt();
			if(i==1) {
				list.add(length);
			}else {
				list.remove(length);
			}
			solution(list);
		}
	}

	private static void solution(List<Integer> list) {
		if (list.size() <= 2) {
			System.out.println("No");
			return;
		}
		int max = Integer.MIN_VALUE;
		int others = 0;
		for (Integer i : list) {
			if (i > max) {
				
				if (max != Integer.MIN_VALUE) {
					others += max;
				}
                max = i;
			} else {
				others += i;
			}
		}
		if (max >= others) {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
	}
}
