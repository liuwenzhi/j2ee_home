package com.duomu.hj44;
import java.util.Scanner;
/**
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 *
 * 输入描述:
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 *
 * 输出描述:
 * 完整的9X9盘面数组
 *
 * 示例1
 * 输入
 * 复制
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * 输出
 * 复制
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            sudoku(matrix, 0, 0);
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    if(j == 8) System.out.println(matrix[i][j]);
                    else System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
    public static boolean sudoku(int[][] matrix, int i, int j) {
        //递归出口条件，9*9矩阵，i和j最大是8
        if(i > 8) {
            return true;
        }
        //当前数字不是0，验证是否正确
        if(matrix[i][j] != 0) {
            if(j < 8 && sudoku(matrix, i, j + 1)) {
                return true; // 未到行位,求解同行下一个
            }
            else if(j >= 8 && sudoku(matrix, i + 1, 0)) {
                return true; // 已到行位,求解下一行第一个
            }
        } else {
            //当前数字是0，看看填什么
            for (int num = 1; num <= 9; num ++) {
                if(check(matrix, i, j, num)) {
                    matrix[i][j] = num;
                    if(j < 8 && sudoku(matrix, i, j + 1)) {
                        return true;
                    }
                    else if(j >= 8 && sudoku(matrix, i + 1, 0)){
                        return true;
                    }
                    matrix[i][j] = 0; // 回溯
                }
            }
        }
        return false;
    }
    // 检查行、列、3*3格
    public static boolean check(int[][] matrix, int i, int j, int num) {
        if(check_row(matrix, i, j, num) && check_col(matrix, i, j, num) && check_3_by_3(matrix, i, j, num)) return true;
        return false;
    }
    // 检查所在行
    public static boolean check_row(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[i][k] == num) return false;
        }
        return true;
    }
    // 检查所在列
    public static boolean check_col(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[k][j] == num) return false;
        }
        return true;
    }
    // 检查所在3*3格
    public static boolean check_3_by_3(int[][] matrix, int i, int j, int num) {
        int row_from = i / 3 * 3;
        int row_to = row_from + 2;
        int col_from = j / 3 * 3;
        int col_to = col_from + 2;
        for (int x = row_from; x <= row_to; x ++) {
            for (int y = col_from; y <= col_to; y ++) {
                if(matrix[x][y] == num) return false;
            }
        }
        return true;
    }
}
