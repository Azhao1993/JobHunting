package Tencent_2017_SummerInternship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	ʱ�����ƣ�1��
	�ռ����ƣ�32768K
	
	СQ�������ϲ���ʱ�뵽��������⣺��n������������ɶ�Ԫ�飬�����С���ж��ٶ��أ��������أ�
	
	��������:
	 	�����������������ݡ�
	
	 ����ÿ��������ݣ�
		 N - �������������n����
		 a1,a2...an - ��Ҫ���������
	
	 ��֤:
	 	1<=N<=100000,0<=ai<=INT_MAX.
	
	�������:
		����ÿ�����ݣ��������������һ������ʾ����С�Ķ������ڶ�������ʾ�����Ķ�����
	
	��������1:
		6
		45 12 45 32 5 6	
	�������1:
		1 2
*/
//��Ȥ������
public class InterestingNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			// ��Сֵ
			int min = Integer.MAX_VALUE;
			// ���ֵ
			int max = Integer.MIN_VALUE;
			// ��Сֵ�ĸ���
			int minCount = 0;
			// ��Сֵ�ĸ���
			int maxCount = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				if (min > arr[i]) {
					min = arr[i];
					minCount = 1;

				} else if (arr[i] == min) {
					minCount++;
				}

				if (max < arr[i]) {
					max = arr[i];
					maxCount = 1;
				} else if (arr[i] == max) {
					maxCount++;
				}

			}
			// ��������е�ֵȫ��ͬ��ֱ���������
			if (min == max) {
				int tmp = (n * (n - 1)) / 2;
				System.out.println(tmp + " " + tmp);
				continue;
			}
			Arrays.sort(arr);// ʱ�临�Ӷ�̫��

			int res_min_dif = 0;
			// ��С��Ϊ0
			if (map.keySet().size() != n) {
				for (Integer temp : map.keySet()) {
					if (map.get(temp) > 1) {
						res_min_dif += (map.get(temp) - 1) * map.get(temp) / 2;
					}
				}
			} else {
				// ��С�Ϊ0
				int mindif = Math.abs(arr[1] - arr[0]);
				// int count = 0;
				for (int i = 2; i < n; i++) {
					if (mindif == Math.abs(arr[i] - arr[i - 1])) {
						res_min_dif++;
					} else if (mindif > Math.abs(arr[i] - arr[i - 1])) {
						mindif = Math.abs(arr[i] - arr[i - 1]);
						res_min_dif = 1;
					}
				}
			}

			System.out.println(res_min_dif + " " + (minCount * maxCount));
		}

	}

}