package Alibaba;

/*
现在有一个真人游戏跳一跳，说是在一个n行n列的方阵,每个位置都有一个可以升降且高度不同的方块，高度是已知的，当人跳上去之后可以自己控制升降，每个方块的升降速度是每1单位时间能升高1单位高度，要求玩家以最快的速度从(0,0)到达(n-1,n-1)的方块，从一个方块跳跃到另外一个方块，只能在高度相同或者从高的往低的移动，如果一个方块的高度比周围的低，那么需要等待方块高度与周围方块任意一个相同时才能移动，请计算等待的最短时间
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static int dump(int[][] grid) {

	}

	public static void main(String[] args) {
//这里的转换已经写好，按照输入描述输入即可,main方法代码不用修改 ，
//重点在实现dump方法
		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String[] array = s.split(";");
		int[][] grid = new int[array.length][array[0].split(",").length];
		for (int i = 0; i < array.length; i++) {
			String[] l = array[i].split(",");
			for (int k = 0; k < l.length; k++) {
				grid[i][k] = Integer.parseInt(l[k]);
			}
		}
		int res = dump(grid);
		System.out.println(String.valueOf(res));
	}
}