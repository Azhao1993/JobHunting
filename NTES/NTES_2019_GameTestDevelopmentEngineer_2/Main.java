package NTES_2019_GameTestDevelopmentEngineer_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
网易游戏（互娱）2019年-游戏测试开发工程师部分真题
糖果谜题
	时间限制：1秒
	空间限制：32768K
	
	小明是幼儿园的一名老师。某天幼儿园园长给小朋友们每人发一颗糖果，
	小朋友们拿到后发现有一些同学拿到的糖果颜色和自己相同，有一些同学糖果颜色和自己不同。
	假定每个小朋友只知道有多少同学和自己拿到了相同颜色的糖果。
	上课后，有一部分小朋友兴奋的把这一结果告诉小明老师，并让小明老师猜一猜，最少有多少同学拿到了糖果。
	例如有三个小朋友告诉小明老师这一结果如下：
	其中第一个小朋友发现有1人和自己糖果颜色一样，第二个小朋友也发现有1人和自己糖果颜色一样，第三个小朋友发现有3人和自己糖果颜色一样。
	第一二个小朋友可互相认为对方和自己颜色相同，比如红色；
	第三个小朋友不可能再为红色（否则第一二个小朋友会发现有2人和自己糖果颜色相同），假设他拿到的为蓝色糖果，那么至少还有另外3位同学拿到蓝色的糖果，最终至少有6位小朋友拿到了糖果。
	现在请你帮助小明老师解答下这个谜题。
	
	输入描述:
		假定部分小朋友的回答用空格间隔，如 1 1 3	
	输出描述:
		直接打印最少有多少位小朋友拿到糖果
		如 6
	
	输入例子1:
		1 1 3	
	输出例子1:
		6
	
	输入例子2:
		0 0 0	
	输出例子2:
		3	
	例子说明2:
		三位小朋友都没发现有人和自己的颜色相同，所以最少的情况就是三位小朋友糖果的颜色均不同
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < strarr.length; i++) {
			int key = Integer.parseInt(strarr[i]);
			if (key == 0) {
				result++;
			} else if (!map.containsKey(key)) {
				map.put(key, 1);
			} else if (map.get(key) <= key) {
				map.put(key, map.get(key) + 1);
			} else {
				result += map.get(key);
				map.put(key, 1);
			}

		}
		for (Integer key : map.keySet()) {
			if (map.get(key) != 0) {
				result += key + 1;
			}
		}
		System.out.println(result);

	}

}
