package com.duomu.hj83;
import java.util.Scanner;
/**
 * 输入描述:
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 *
 * 输出描述:
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 *
 * 示例1
 * 输入
 * 复制
 * 4 9
 * 5 1 2 6
 * 0
 * 8
 * 2 3
 * 4 7
 * 4 2 3 2
 * 3
 * 3
 * 4 7
 * 输出
 * 复制
 * 0
 * -1
 * 0
 * -1
 * 0
 * 0
 * -1
 * 0
 * 0
 * -1
 * 说明
 * 本组样例共有2组样例输入。
 * 第一组样例：
 * 1.初始化数据表为4行9列，成功
 * 2.交换第5行1列和第2行6列的数据，失败。因为行的范围应该是(0,3)，不存在第5行。
 * 3.在第0行左边添加一行，成功。
 * 4.在第8列上方添加一列，失败。因为列的总数已经达到了9的上限。
 * 5.查询第2行第3列的值，成功。
 * 第二组样例：
 * 1.初始化数据表为4行7列，成功
 * 2.交换第4行2列和第3行2列的数据，失败。因为行的范围应该是(0,3)，不存在第4行。
 * 3.在第3行左边添加一行，成功。
 * 4.在第3列上方添加一列，成功。
 * 5.查询第4行7列的值，失败。因为虽然添加了一行一列，但数据表会在添加后恢复成4行7列的形态，所以行的区间仍然在[0,3]，列的区间仍然在[0,6]，无法查询到(4,7)坐标。
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt(), n = cin.nextInt();
            //超过9行9列就失败，9行9列以内就成功
            if (m > 9 || n > 9) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }

            //要交换的两个坐标都在初始化矩阵范围内，注意：这里测试用例测试的坐标范围是0到m-1,0到n-1，题目中说的行和列都是从0开始算的
            int a = cin.nextInt(), b = cin.nextInt(), c = cin.nextInt(), d = cin.nextInt();
            if (a >= 0 && a < m && b >= 0 && b < n && c >= 0 && c < m && d >= 0 && d < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            //题目说的有点问题：应该是在行的上方插入一行，在列的左侧插入一列
            int row = cin.nextInt();
            if (row >=m || m==9) { //注意m和n若为9则无法插入，肯定会超过9行或者9列，本题细节和边界比较多
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            int col = cin.nextInt();
            if (col >=n || n==9) {
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            int x = cin.nextInt(), y = cin.nextInt();
            if (x >= 0 && x < m && y >= 0 && y < n) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
