package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] flag = new boolean[N];
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(i==0) {
				ArrayList<Node> temp = new ArrayList<>();
				temp.add(new Node(x,y));
				list.add(temp);
			}else {
				Node tempNode = new Node(x,y);
				if(isLine(tempNode,list)) {
					continue;
				}else {
					
				}
			}
			
		}

	}

	private static boolean isLine(Node tempNode, ArrayList<ArrayList<Node>> list) {
		// TODO Auto-generated method stub
		return false;
	}

}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
