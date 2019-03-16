package ByteDance_2019_houduan;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nstr = sc.nextLine();
		int n = Integer.parseInt(nstr);
		for (int i = 0; i < n; i++) {
			String temp = sc.nextLine();
			solution(temp);
		}
	}

	private static void solution(String temp) {
		StringBuilder sb = new StringBuilder(temp);
		if (temp.length() <= 2) {
			System.out.println(temp);
			return;
		}
		
		int i =0;
		int j;
		int x;
		int y;
		while(i<=sb.length()-3) {
			char ti = sb.charAt(i);
			j=i+1;
			char tj = sb.charAt(j);
			if(ti!=tj) {
				i++;
				continue;
			}else {
				x=j+1;
				char tx = sb.charAt(x);
				if(tj==tx) {
					sb.deleteCharAt(x);
				}else {
					y=x+1;
					if(y>sb.length()-1) {
						break;
					}
					char ty = sb.charAt(y);
					if(tx==ty) {
						sb.deleteCharAt(y);
					}else {
						i++;
					}
				}
			}
		}
//		for (i = 0; i < sb.length() - 3; i++) {
//			char ti = sb.charAt(i);
//			for (j = i + 1; j < sb.length() - 2; j++) {
//				char tj = sb.charAt(j);
//				if (ti != tj) {
//					break;
//				}
//				for (x = j + 1; x < sb.length() - 1;) {
//					char tx = sb.charAt(x);
//					if (tj == tx) {
//						sb.deleteCharAt(x);
//					} else {
//						for (y = x + 1; y < sb.length();) {
//							char ty = sb.charAt(y);
//							if (tx == ty) {
//								sb.deleteCharAt(y);
//							} else {
//								break;
//							}
//						}
//					}
//
//				}
//			}
//		}
		System.out.println(sb.toString());

	}

}
