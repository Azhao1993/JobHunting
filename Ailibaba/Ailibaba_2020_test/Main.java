package Ailibaba_2020_test;

/*
题目描述：

小广附近有家盒马店，该店提供配送服务，配送范围是系统根据各项指标决策出的一个多边形，假设小广现在的位置为（x,y），请问小广是否在该盒马店的配送范围内，如果不在配送范围内请问他要最少要走多少距离才能到盒马店配送范围内。假设坐标点在二维平面上，不考虑地球曲率等因素。

 

输入：

x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)

x1,y1,x2,y2,x3,y3....xn,yn(代表该盒马店的配送范围多边形，其中x表示横坐标，y表示纵坐标，xi和yi代表多边形一个点，点与点按顺序相连形成边，并且最后一个点(xn,yn)与第一个点(x1,y1)相连）

输出：

请问小广是否在盒马店的配送范围内，如果不在配送范围内请问他要最少走多少距离才能到盒马店配送范围内，输出结果为整数（四舍五入）

 

举例说明：

输入：

1,1
0,0,0,2,2,2,2,0

输出：

yes,0

 

输入：

2,2
0,0,0,2,2,2,2,0

输出：

yes,0

 

输入：

3,0
0,0,0,2,2,2,2,0

输出：

no,1

 

输入：

3,4
0,0,0,2,2,2,2,0

输出：

no,2
 */
import java.util.*;
import java.util.List;

public class Main {
	/** 请完成下面这个函数，实现题目要求的功能 **/
	/**
	 * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
	 **/
	public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		// (x,y)为小广所在的位置
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);

		line = in.nextLine();
		// xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
		List<Double> xList = new ArrayList<>();
		List<Double> yList = new ArrayList<>();
		String[] array = line.split(",");
		for (int i = 0; i < array.length; i++) {
			xList.add(Double.parseDouble(array[i]));
			yList.add(Double.parseDouble(array[i + 1]));
			i++;
		}
		in.close();
		System.out.println(measureDistance(xList, yList, x, y));
	}
}
