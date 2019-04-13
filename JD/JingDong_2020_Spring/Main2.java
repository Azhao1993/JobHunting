package JingDong_2020_Spring;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		for(int i = 0;i<n;i++) {
			strs[i] = sc.nextLine();			
		}
		String T = sc.nextLine();
		int res = 0;
		res = process(strs,T,res,0,0);
		System.out.println(res);
	}
	
	

	private static int process(String[] strs, String t, int res,int index, int sum) {
		if(index>=t.length()) {
			res = Math.max(res, sum);
			return res;
		}
		for(int i = 0;i<strs.length;i++) {
			int lastIndex = index;
			int lastSum = sum;
			index = t.indexOf(strs[i],index);
			if(index==-1) {
				index = lastIndex;
				res = Math.max(res, sum);
				continue;
			}else {
				index += strs[i].length();
				sum++;
			}
			process(strs,t,res,sum,index);
			index = lastIndex;
			sum =lastSum;
		}
		return res;
	}
}
