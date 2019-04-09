package xinyongka_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();		
		int[] arr = new int[2*n];
		for(int i = 0;i<2*n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		double result = 0;
		//Å®º¢×î¶à
		double ladyMax = arr[0];
		double manMax = arr[n];		
		if(manMax>=ladyMax*2) {
			result = ladyMax*3*n;
		}else {
			result = manMax/2*3*n;
		}
		result = result > w ? w : result ;
		System.out.println(String .format("%.6f",result));
	}
}
