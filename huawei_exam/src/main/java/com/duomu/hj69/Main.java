package com.duomu.hj69;
import java.util.Scanner;
/**
 * 题目描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 * 输入描述:
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 * 输出描述:
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 * 输出
 * 14 13
 * 10 11
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //矩阵1的行数
            int x = scanner.nextInt();
            //矩阵1的列数，矩阵2的行数
            int y = scanner.nextInt();
            //矩阵2的列数
            int z = scanner.nextInt();
            //通过二维数组给矩阵赋值
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            for(int i=0;i<x;i++){
                for(int j=0;j<y;j++){
                    matrix1[i][j] = scanner.nextInt();
                }
            }
            for(int i=0;i<y;i++){
                for(int j=0;j<z;j++){
                    matrix2[i][j] = scanner.nextInt();
                }
            }
            matrixCompute(x,y,z,matrix1,matrix2);
        }
        scanner.close();
    }

    /**
     * 矩阵乘法
     */
    private static void matrixCompute(int x,int y,int z,int[][] matrix1,int[][] matrix2){
        int[][] result = new int[x][z];
        //第一层循环，遍历矩阵1的行
        for(int i=0;i<x;i++){
            //第二层循环，遍历矩阵2的列
            for(int k=0;k<z;k++) {
                int temp = 0;
                //第三层循环，遍历矩阵1的列和矩阵2的行
                for (int j = 0; j < y; j++) {
                    temp += matrix1[i][j] * matrix2[j][k];
                }
                result[i][k] = temp;
            }
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<z;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
