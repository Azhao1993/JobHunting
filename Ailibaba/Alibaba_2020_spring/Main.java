package Alibaba;
/*
�ڷ���������ǧ�򼶾Ƶ�������һ�����С���Ḩ����Ӫ�Ƶ꣬

����Ŀǰ��9�����еľƵ���3��С������Ӫ��

�Ժ����򱱾�����Ļ�����ô���ݡ����ݡ��Ϻ�����ӪС��A,�Ͼ������Ϲ���ӪС��B,ʯ��ׯ��֣�ݡ���򡢱�������ӪС��C,

Ϊ�˷�����Ӫ�������õ���λ�ýϽ��ĳ��й���һ��С������Ӫ��������������һ������( 1 -  n)��

С��A������Ӫ 1��2��3�����ǲ�����Ӫ1��2��4��һ��һ������ֻ����һ������С����Ӫ������ÿ�����оƵ��������һ�£�������ǿ�Ȳ���ϴ�

�������ڷ��䲻���⵼����Щ�Ƶ��������������Ҫ������С���Ĺ���������Ӿ��⣬������С��

�����n������,k����ӪС���������Ӫ�������һ�������ķ��䷽���ɡ���������k��С����Ҫ��Ӫ�ĳ��и���,

�������б�չʾ����,��H1,...,Hn��ʾ�����еľƵ�������

����1:

���룺

    9

    3

    1, 2, 3, 1, 1, 3, 2, 3, 4

���:   3;4;2;   (ÿ��С��֮���÷ֺŸ���)

 

˵��:

 1+2+3 =6      С��A��Ҫ��Ӫ�ľƵ�,3������

 1+1+3+2 =7  С��B��Ҫ��Ӫ�ľƵ�,4������

 3+4  =7         С��C��Ҫ��Ӫ�ľƵ�,2������

ע��:�ڷ�������У���Ӫ������һ��Ҫ����,���з����ǰ�ɺ������£����ȷ��������С������������ǿ��С���е���Щ��

�������Ӹĳɣ� 1+2+3+1 =7��1+3+2 =6��3+4 =7���ǲ��еģ�������˵ 6��7��7��7��6��7û���𣬾�����Ҫ����˵��6��7��7����ȷ��
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** ������������������ʵ����ĿҪ��Ĺ��� **/
 /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static String citys(int n, int k, int[] hotels) {


    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());


        String hotelsStr = in.nextLine().trim();
        String[] hotelArray = hotelsStr.split(",");
        int[] _hotels = new int[hotelArray.length];

        for(int _hotels_i = 0; _hotels_i < hotelArray.length; _hotels_i++) {
            _hotels[_hotels_i] = Integer.parseInt(hotelArray[_hotels_i]);
        }

        res = citys(_n, _k, _hotels);
        System.out.println(res);
    }
}
