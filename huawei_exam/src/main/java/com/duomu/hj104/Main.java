package com.duomu.hj104;

import java.util.Scanner;
/**
 * 题目描述
 * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 *
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 首先输入一个整数，为要输入的字符串个数。
 *
 * 例如：
 *
 * 输入：2
 *
 * abc
 *
 * 12345789
 *
 * 输出：abc00000
 *
 * 12345678
 *
 * 90000000
 *
 * 接口函数设计如下:
 *
 * /*****************************************************************************
 * 功能:存储输入的字符串
 *
 * 输入:字符串
 *
 * 输出:无
 *
 * 返回:0表示成功,其它返回-1
 *
         *int AddString(char*strValue);
         * /****************************************************************************
  * 功能:获取补位后的二维数组的长度
  *
  * 输入:无
  *
  * 输出:无
  *
  * 返回:二维数组长度
         *
         *int GetLength();
         *
         *
         * /*****************************************************************************
  * 功能:将补位后的二维数组，与输入的二维数组做比较
  *
  * 输入:strInput:输入二维数组,iLen：输入的二维数组的长度
  *
  * 输出:无
  *
  * 返回:若相等,返回0;不相等,返回-1.其它:-1;
         *int ArrCmp(char strInput[][9],int iLen);
         *
         *
         *输入描述:
         *首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
         *
         *输出描述:
         *按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
         *
         *示例1
         *复制
         *2
         *abc
         *123456789
         *输出
         *abc00000
         *12345678
         *90000000
 */
public class Main {
    /**
     * 本题和第四题非常类似
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //本题题目描述有问题，还是要多组输入，最外层需要套一层while循环
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                String line = scanner.next();
                StringBuilder sb = new StringBuilder(line);
                if (sb.length() % 8 != 0) {
                    int n = 8 - line.length() % 8;
                    for (int j = 0; j < n; j++) {
                        sb.append("0");
                    }
                }
                while (sb.length() >= 8) {
                    System.out.println(sb.substring(0, 8));
                    sb = sb.delete(0, 8);
                }
            }
        }
        scanner.close();
    }
}
