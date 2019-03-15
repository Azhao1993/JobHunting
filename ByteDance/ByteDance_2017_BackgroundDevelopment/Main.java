package ByteDance_2017_BackgroundDevelopment;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] map = new long[10][2];
		for(int i = 0;i<n;i++) {
			String temp = sc.next();
			int length = temp.length();
			for(int j = 0;j<length;j++) {
				int index = temp.charAt(j)-'A';
				map[index][0] += (long)Math.pow(10, length-1-j);
				if(j==0) {
					map[index][1] = 1;
				}
			}
		}
		//ÅÅÐò
		int zflag = -1;//0µÄÎ»ÖÃ
		for(int i = 0;i<9;i++) {
			for(int j = i+1;j<10;j++) {
				if(map[j][0]>map[i][0]) {
					long temp = map[j][0];
					long temp2 = map[j][1];
					map[j][0] = map[i][0];
					map[j][1]= map[i][1];
					map[i][0]=temp;
					map[i][1]=temp2;
				}
			}
			if(map[i][1]==0) {
				zflag = i;
			}
		}
		if(map[9][1]==0) {
			zflag = 9;
		}
		int bit = 9;
		long result = 0;
		for(int i = 0;i<10;i++) {
			if(i!=zflag) {
				result += map[i][0]*bit;
				bit--;
			}
		}		

		System.out.println(result);
	}
}
