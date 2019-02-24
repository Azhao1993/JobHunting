package Tencent_2017_SummerInternship;

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
import java.util.Scanner;
import java.util.HashMap;

public class InterestingNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(strarr[i]);
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = Math.abs(arr[i] - arr[j]);
				if (map.containsKey(temp)) {
					int count = map.get(temp);
					map.put(temp, count + 1);
				} else {
					map.put(temp, 1);
				}
			}
		}
		int[][] result = new int[map.size()][2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int b = 0;
		for (Integer y : map.keySet()) {
			result[b][0] = y;
			result[b++][1] = map.get(y);
			if (y <= min) {
				min = y;
			} else if (y >= max) {
				max = y;
			}
		}
		int resultMin = 0;
		int resultMax = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i][0] == min) {
				resultMin = result[i][1];
			}
			if (result[i][0] == max) {
				resultMax = result[i][1];
			}
		}
		System.out.println(resultMin + " " + resultMax);

	}

}
