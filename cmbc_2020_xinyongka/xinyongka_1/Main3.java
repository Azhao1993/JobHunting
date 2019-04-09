package xinyongka_1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if (o1.value < o2.value) {
					return -1;
				} else if (o1.value > o2.value) {
					return 1;
				} else {
					o1.times += o2.times;
					return 0;
				}
			}
		});
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			a[i] = sc.nextInt();
			Node node = new Node(temp, 1);
			queue.add(node);
		}
	}

}

class Node {
	int value;
	int times;

	public Node(int val, int time) {
		this.value = value;
		this.times = time;
	}
}
