package HUAWEI_2020;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();		
		sc.nextLine();
		ArrayList<StringBuilder> list = new ArrayList<>();
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] arr = str.split(",");
			StringBuilder sb = new StringBuilder();
			for (String s : arr) {
				sb.append(s);
			}
			list.add(sb);
		}

		// ½á¹û
		StringBuilder res = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		while (list.size() > 0) {
			for (int i = 0; i < list.size();) {
				StringBuilder sb = list.get(i);
				sb.insert(0, tmp);
				if (sb.length() >= length) {
					for (int j = 0; j < length; j++) {
						res.append(sb.charAt(0)).append(",");
						sb.deleteCharAt(0);
					}
					if (sb.length() == 0) {
						list.remove(i);
					} else {
						i++;
					}
				} else if (list.size() > 1) {
					tmp = sb;
					list.remove(i);
				} else {
					for (int j = 0; j < sb.length(); j++) {
						res.append(sb.charAt(j)).append(",");
					}
					list.remove(i);
				}
			}
		}
		if (res.length() == 0) {
			System.out.println("");
		} else {
			res.deleteCharAt(res.length() - 1);
			System.out.println(res.toString());
		}

	}
}
