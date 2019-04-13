package MIHAYOU_2020_chunzhao;

import java.util.Scanner;

public class Main {
	//java.lang.OutOfMemoryError
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// N个点
		boolean[][] area = new boolean[65530][65530];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();// 横坐标
			int y = sc.nextInt();// 纵坐标
			int w = sc.nextInt();// 边长
			fillArea(x, y, w, area);
		}
		int result = 0;
		for(int i = 0;i<65530;i++) {
			for(int j = 0;j<65530;j++) {
				if(area[i][j]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	private static void fillArea(int x, int y, int w, boolean[][] area) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				if(area[x+i][y+j]) {
					continue;
				}else {
					area[x+i][y+j] = true;
				}
			}
		}

	}
}
