package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: ���⵽�ڵ��������� ת��Ϊ ���ڵ������������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/15 , 15:42
 */
public class Matrix_4_SpiralReverse {

    public static void main(String[] args){
        int[][] matrix1 = Matrix_4_Spiral.buildSpiralMatrix(6);
        Matrix_4_Spiral.print(matrix1);
        Matrix_4_Spiral.print(reverseSpiralMatrix(matrix1));

        int[][] matrix2 = Matrix_4_Spiral.buildSpiralMatrix(7);
        Matrix_4_Spiral.print(matrix2);
        Matrix_4_Spiral.print(reverseSpiralMatrix(matrix2));

        int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        Matrix_4_Spiral.print(matrix);
        Matrix_4_Spiral.print(reverseSpiralMatrix(matrix));
        int[][] matrix4 = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        Matrix_4_Spiral.print(matrix4);
        Matrix_4_Spiral.print(reverseSpiralMatrix(matrix4));


    }
    /* ���ɣ� ����������� �ȴ�ֱ�Գƣ�Ȼ��ÿһ��ֵ���� n*n +1 - x ����  ;�����ż����ˮƽ�Գ� */
    public static int[][] reverseSpiralMatrix(int[][] matrix){
        int n = matrix.length;
        if(n%2 == 1){
            for(int i = 0 ; i< n ; i++){
                for( int j = 0 ; j <= n/2; j ++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-1-j];
                    matrix[i][n-1-j] = temp;
                }
            }
        }
        else{
            for(int i = 0 ; i< n ; i++){
                for( int j = 0 ; j <= n/2 -1; j ++){
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = temp;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for( int j = 0 ; j < n ; j++){
                matrix[i][j] = n*n+1 - matrix[i][j];
            }
        }
        return matrix;
    }
}
