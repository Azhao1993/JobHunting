
package NETS;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();//q�����Ե�		
		for(int i = 0;i<q;i++) {
			int n = sc.nextInt();//n��
			int m = sc.nextInt();//m��
			int x = sc.nextInt();//���Ժ�����
			int y = sc.nextInt();//��ʼ�����
			int w = sc.nextInt();//�˶�����
			int t = sc.nextInt();//�뿪��ʱ��
			int[] res = {0};
			sloution(n,m,x,y,w,t,res);
			System.out.println(res[0]);					
		}
	}

	private static void sloution(int n, int m, int x, int y, int w, int t,int[] res) {
		//0:���ϣ�1�����ϣ�2�����£�3������
		//�����˶�����ǽ���������˶����������
		//�ϻ����£��������	
		if(t<=0) {
			return;
		}
		if(w==0) {
			int stepx = y-1;//����Ĳ���
			int stepy = x-1;//���ϵĲ���
			if(stepx==stepy) {
				t-=stepx;
				if(t>=0) {
					res[0]+=2;
				}else {
					return;
				}
				w = 2;
				x = 1;
				y = 1;
				sloution(n,m,x,y,w,t,res);
			}else if(stepx>stepy){
				//ײ���ϱ�
				t -= stepy;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				x = 1;
				y = y-stepy;
				w = 2;
				sloution(n,m,x,y,w,t,res);				
			}else {
				//ײ�������
				t -= stepx;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				y = 1;
				x = x-stepx;
				w = 1;
				sloution(n,m,x,y,w,t,res);	
			}
		}else if(w==1) {
			//����
			int stepx = m-y;//���ҵĲ���
			int stepy = x-1;//���ϵĲ���
			if(stepx==stepy) {
				t-=stepx;
				if(t>=0) {
					res[0]+=2;
				}else {
					return;
				}
				w = 3;
				x = 1;
				y = m-1;
				sloution(n,m,x,y,w,t,res);
			}else if(stepx>stepy){
				//ײ���ұ�
				t -= stepy;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				y = m-1;
				x = x-stepy;
				w = 0;
				sloution(n,m,x,y,w,t,res);				
			}else {
				//ײ�����ϱ�
				t -= stepx;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				x = 1;
				y = y+stepx;
				w = 2;
				sloution(n,m,x,y,w,t,res);	
			}
		}else if(w==2) {
			//����
			int stepx = m-y;//���ҵĲ���
			int stepy = n-x;//���µĲ���
			if(stepx==stepy) {
				t-=stepx;
				if(t>=0) {
					res[0]+=2;
				}else {
					return;
				}
				w = 0;
				x = n-1;
				y = m-1;
				sloution(n,m,x,y,w,t,res);
			}else if(stepx>stepy){
				//ײ���ұ�
				t -= stepy;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}				
				x = x+stepy;
				y = m-1;
				w = 3;
				sloution(n,m,x,y,w,t,res);				
			}else {
				//ײ�����±�
				t -= stepx;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				x = n-1;
				y = y+stepx;
				w = 1;
				sloution(n,m,x,y,w,t,res);	
			}
		}else{
			//����
			int stepx = y-1;//����Ĳ���
			int stepy = n-x;//���µĲ���
			if(stepx==stepy) {
				t-=stepx;
				if(t>=0) {
					res[0]+=2;
				}else {
					return;
				}
				w = 1;
				x = n-1;
				y = 1;
				sloution(n,m,x,y,w,t,res);
			}else if(stepx>stepy){
				//ײ�����
				t -= stepy;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}				
				x = x+stepy;
				y = 1;
				w = 2;
				sloution(n,m,x,y,w,t,res);				
			}else {
				//ײ�����±�
				t -= stepx;
				if(t>=0) {
					res[0]++;
				}else {
					return;
				}
				x = n-1;
				y = y-stepx;
				w = 0;
				sloution(n,m,x,y,w,t,res);	
			}
		}
		
		
	}

}
