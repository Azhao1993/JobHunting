package ByteDance_2019_BackgroundDevelopment_1;

import java.util.Scanner;

/*
	�ڶ���:
		1.����ͬ������ĸ����һ��һ����ƴд����ȥ��һ���ͺ��ˡ�����:helllo --> hello
		2.����һ������ĸ(AABB��)����һ��һ����ƴд����ȥ���ڶ��Եĵ�һ����ĸ������:helloo --> hello
		3.����Ĺ������ȡ������ҡ�ƥ�䣬�������AABBCC�ͣ�Ӧ���ȿ����޸�AABBΪAABCC��
 */
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

		int i = 0;
		int j;
		int x;
		int y;
		while (i <= sb.length() - 3) {
			char ti = sb.charAt(i);
			j = i + 1;
			char tj = sb.charAt(j);
			if (ti != tj) {
				i++;
				continue;
			} else {
				x = j + 1;
				char tx = sb.charAt(x);
				if (tj == tx) {
					sb.deleteCharAt(x);
				} else {
					y = x + 1;
					if (y > sb.length() - 1) {
						break;
					}
					char ty = sb.charAt(y);
					if (tx == ty) {
						sb.deleteCharAt(y);
					} else {
						i++;
					}
				}
			}
		}
		System.out.println(sb.toString());

	}

}
