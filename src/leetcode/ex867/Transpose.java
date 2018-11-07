package leetcode.ex867;

import java.util.Arrays;

/**
 * @Author: myname
 * @Date: 2018/11/7 10:22
 * 转置矩阵,矩阵行列互换
 */
public class Transpose {
    //m*n矩阵 变成 n*m矩阵
    public static int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] AT = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                AT[i][j] = A[j][i];
            }
        }
        return AT;
    }
    public static void printArrays(int[][] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            int m = A[i].length;
            for(int j=0;j<m;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr= new int[][]{ {1,2,3},{4,5,6},{7,8,9}};
        printArrays(arr);
        System.out.println();
        printArrays( transpose(arr) );
    }
}
