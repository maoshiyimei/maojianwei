package com.maji.maojianwei.leetcode.tempWorkspace; /**
 * Class:��������һλ���а����׶�԰��ʦ����Ҫ���׶�԰��С������һЩС�ǹ���
 * ���ǣ�ÿ���������ֻ�ܸ�һ���ǹ�����ÿ������ i ������һ��θ��ֵ gi ��
 * �������ú���������θ�ڵ��ǹ�����С�ߴ磻����ÿ���ǹ� j ������һ���ߴ� sj ����� sj >= gi ��
 * ���ǿ��Խ�����ǹ� j ��������� i ��
 * ������ӻ�õ����㡣���Ŀ���Ǿ���������Խ�������ĺ��ӣ��������������ֵ��
 *
 * 1 2 3
 * 1 1 - > 1
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/19 , 21:24
 */
import java.util.*;
public class Array_3_SeparateCandi{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String g = in.nextLine();
        String s = in.nextLine();
        String[] arrayG = g.split("\\s+");
        String[] arrayS = s.split("\\s+");
        List<Integer> listG = new ArrayList<>();
        List<Integer> listS = new ArrayList<>();
        for(String sunString : arrayG){
            listG.add(Integer.valueOf(sunString));
        }
        for(String sunString : arrayS){
            listS.add(Integer.valueOf(sunString));
        }
        System.out.println(solution(listG, listS));
    }
    /* ̰��˼·: ע�⵱���ǹ�������ʱ��Ҫ������ȫ�����ǹ� */
    public static int solution(List<Integer> listG, List<Integer> listS){
        Collections.sort(listG);
        Collections.sort(listS);
        int n = listG.size();
        int m = listS.size();
        int count=0;
        for(int i = 0, j = 0 ; i < m && j < n ; i++){
            if(listS.get(i) >= listG.get(j) ){
                count++;
                j++;
            }
        }
        return count;
    }
}
