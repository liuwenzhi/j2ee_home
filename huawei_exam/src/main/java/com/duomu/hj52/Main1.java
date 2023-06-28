package com.duomu.hj52;

import java.util.Scanner;
/**
 * 如果两个串的第一个字符相同
 * ，如A=xabcdae和B=xfdfa，只要计算A[2,…,7]=abcdae和B[2,…,5]=fdfa的距离就可以了。
 * 如果两个串的第一个字符不相同，那么可以进行如下的操作：
 * 1．删除A串的第一个字符，然后计算A[2,…,lenA]和B[1,…,lenB]的距离。
 * 2．删除B串的第一个字符，然后计算A[1,…,lenA]和B[2,…,lenB]的距离。
 * 3．修改A串的第一个字符为B串的第一个字符，然后计算A[2,…,lenA]和B[2,…,lenB]的距离。
 * 4．修改B串的第一个字符为A串的第一个字符，然后计算A[2,…,lenA]和B[2,…,lenB]的距离。
 * 5．增加B串的第一个字符到A串的第一个字符之前，然后计算A[1,…,lenA]和B[2,…,lenB]的距离。
 * 6．增加A串的第一个字符到B串的第一个字符之前，然后计算A[2,…,lenA]和B[1,…,lenB]的距离。
 * 动态规划思路为：
 * * 设Ai为字符串A(a1a2a3 … am)的前i个字符（即为a1,a2,a3 … ai）
 *     * 设Bj为字符串B(b1b2b3 … bn)的前j个字符（即为b1,b2,b3 … bj）
 *     * 设 L(i,j)为使两个字符串和Ai和Bj相等的最小操作次数。
 *     * 当ai==bj时 显然 L(i,j) = L(i-1,j-1)
 *     * 当ai!=bj时
 *     *  若将它们修改为相等，则对两个字符串至少还要操作L(i-1,j-1)次
 *     *  若删除ai或在bj后添加ai，则对两个字符串至少还要操作L(i-1,j)次
 *     *  若删除bj或在ai后添加bj，则对两个字符串至少还要操作L(i,j-1)次
 *     *  此时L(i,j) = min( L(i-1,j-1), L(i-1,j), L(i,j-1) ) + 1
 *     * 显然，L(i,0)=i，L(0,j)=j, 再利用上述的递推公式，可以直接计算出L(i,j)值。
 */
public class Main1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(stringDistance(str1.toCharArray(),str2.toCharArray()));
        }
    }
    private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];

        for (int i = 0; i < len.length; i++) {
            len[i][0] = i;
        }

        for (int j = 0; j < len[0].length; j++) {
            len[0][j] = j;
        }

        for (int i = 1; i < len.length; i++) {
            for (int j = 1; j < len[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }
        return len[len.length - 1][len[0].length - 1];
    }
}
