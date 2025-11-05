package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 * ���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ�
 * ���С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��
 * ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 * ʾ��:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * ���� word = "ABCCED", ���� true
 * ���� word = "SEE", ���� true
 * ���� word = "ABCB", ���� false
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 20:21
 */
public class BackTrack_4_WordFinding {
    public static int count = 0;
    public static boolean flag = false;

    public static char[][] letters = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };
    public static String word = "ABCCED";
    public static int n = letters.length;
    public static int m = letters[0].length;
    public static void main(String[] args){
        System.out.println( exist() );
    }

    public static boolean exist() {
        for(int i = 0 ;i < n ; i++){
            for( int j = 0 ;j < m ;j++){
                if( letters[i][j] == word.charAt(0)){
                    count = 1;
                    findWord( i, j, 0);
                    if(flag){
                        return true;
                    }

                }
            }
        }
        return false;
    }
    /* ����©�������ܺ����ı������õ�֮ǰ���ַ����´��� */


    public static void findWord(int row, int col, int direction){
        if(row<0 || row >= n || col < 0 || col >= m || count == word.length()  ){
            if(count == word.length() ){
                flag = true;
            }
        }
        else{
            if(direction != 1  && row-1 >= 0  && word.charAt(count) == letters[row-1][col] ){
                count++;
                findWord(row-1,col, 3);
                count--;
            }
            if(direction != 2  && col+1 < m  && word.charAt(count) == letters[row][col+1] ){
                count++;
                findWord(row,col+1, 4);
                count--;
            }
            if(direction != 3  && row+1 < n  && word.charAt(count) == letters[row+1][col] ){
                count++;
                findWord(row+1,col, 1);
                count--;
            }
            if(direction != 4  && col-1 >= 0  && word.charAt(count) == letters[row][col-1] ){
                count++;
                findWord(row,col-1, 2);
                count--;
            }
        }
    }
}
