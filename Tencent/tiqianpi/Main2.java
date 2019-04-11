package tiqianpi;


import java.util.Scanner;

//简单的约瑟夫环求解
public class Main2 {
    static final int Num=6;    //总人数
    static final int KillMan=4;        //自杀者报数
    //约瑟夫环算法
    static void josephus(int alive){
        int []man = new int[Num];
        int count=1;
        int i=0,pos=-1;
        while(count<=Num){
            do{
                pos=(pos+1)%Num;   //环处理
                if(man[pos]==0)   //只有没自杀的人才不等于0
                    i++;
                if(i==KillMan){   //该人自杀
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
        System.out.print("约瑟夫环问题求解！\n");
        System.out.print("请输入需要留存的人的数量：");
        Scanner input = new Scanner(System.in);
        alive = input.nextInt();
        josephus(alive);
    }
}