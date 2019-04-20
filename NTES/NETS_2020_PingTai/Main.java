package Nets;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();// q个测试点
		for (int i = 0; i < q; i++) {
			int n = sc.nextInt();// n行
			int m = sc.nextInt();// m列
			int x = sc.nextInt();// 初试横坐标
			int y = sc.nextInt();// 初始纵左边
			int w = sc.nextInt();// 运动方向
			int t = sc.nextInt();// 离开的时间
			int[] res = { 0 };
			sloution(n, m, x, y, w, t, res);
			System.out.println(res[0]);
		}
	}

	private static void sloution(int n, int m, int x, int y, int w, int t,int[] res) {
		//0:左上，1：右上，2：右下，3：左下
		//向上运动碰到墙会变成向下运动，左会变成右
		//上会变成下，左会变成右
		int stepx = 0, stepy = 0;	
		while(t > 0){
			// 需要运动的次数
			switch(w){
				// 左上方向
				case 0:
					stepx = y-2;
					stepy = x-2;
					if(stepx == stepy){
						// 撞到 1, 1
						t -= stepx;
						if(t > 0) res[0] += 2;
						w = 2;
						x = 2;
						y = 2;
					}else if(stepx > stepy){
						//撞到上边
						t -= stepy;
						if(t > 0) res[0]++;
						x = 2;
						y = y-stepy;
						w = 3;
					}else {
						//撞到了左边
						t -= stepx;
						if(t>=0) res[0]++;
						y = 2;
						x = x-stepx;
						w = 1;
					}break;
				case 1:
					//右上
					stepx = m-1-y;//向右的步数
					stepy = x-2;//向上的步数
					if(stepx==stepy) {
						t-=stepx;
						if(t>0) res[0]+=2;
						w = 3;
						x = 2;
						y = m-1;
					}else if(stepx>stepy){
						//撞到右边
						t -= stepy;
						if(t>0) res[0]++;
						y = m-1;
						x = x-stepy;
						w = 0;			
					}else {
						//撞到了上边
						t -= stepx;
						if(t>=0) res[0]++;
						x = 2;
						y = y+stepx;
						w = 2;
					}break;
				case 2:
					//右下
					stepx = m-1-y;//向右的步数
					stepy = n-1-x;//向下的步数
					if(stepx==stepy) {
						t-=stepx;
						if(t>0) res[0]+=2;
						w = 0;
						x = n-1;
						y = m-1;
					}else if(stepx>stepy){
						//撞到右边
						t -= stepy;
						if(t>0) res[0]++;
						x = x+stepy;
						y = m-1;
						w = 3;			
					}else {
						//撞到了下边
						t -= stepx;
						if(t>=0) res[0]++;
						x = n-1;
						y = y+stepx;
						w = 1;
					}break;
				case 3:
					//坐下
					stepx = y-2;//向左的步数
					stepy = n-1-x;//向下的步数
					if(stepx==stepy) {
						t-=stepx;
						if(t>0) res[0]+=2;
						w = 1;
						x = n-1;
						y = 2;
					}else if(stepx>stepy){
						//撞到左边
						t -= stepy;
						if(t>=0) res[0]++;				
						x = x+stepy;
						y = 2;
						w = 2;			
					}else {
						//撞到了下边
						t -= stepx;
						if(t>=0) res[0]++;
						x = n-1;
						y = y-stepx;
						w = 0;
					}break;
			}
		}
	}
}