package tiqianpi;


import java.util.Scanner;

//�򵥵�Լɪ�����
public class Main2 {
    static final int Num=6;    //������
    static final int KillMan=4;        //��ɱ�߱���
    //Լɪ���㷨
    static void josephus(int alive){
        int []man = new int[Num];
        int count=1;
        int i=0,pos=-1;
        while(count<=Num){
            do{
                pos=(pos+1)%Num;   //������
                if(man[pos]==0)   //ֻ��û��ɱ���˲Ų�����0
                    i++;
                if(i==KillMan){   //������ɱ
                    i=0;
                    break;
                }            
            }while(true);
            man[pos]=count;
            System.out.print(pos+1);
            if(count<Num-1) {            	
            	System.out.print(" ");            	
            }else {
            	System.out.println();
            }
            count++;
        }        
        alive = Num - alive;        
    }
    public static void main(String[] args){
        int alive;
        System.out.print("Լɪ��������⣡\n");
        System.out.print("��������Ҫ������˵�������");
        Scanner input = new Scanner(System.in);
        alive = input.nextInt();
        josephus(alive);
    }
}