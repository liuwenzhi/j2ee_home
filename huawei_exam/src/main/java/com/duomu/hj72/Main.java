package com.duomu.hj72;

import java.util.Scanner;

/**
 * 注意华为的上机考试，不要想着怎么判断输入结束这方面，容易进坑
 * 描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * int GetResult(vector &list)
 *
 * 输入参数：
 *
 *         无
 *
 * 输出参数（指针指向的内存区域保证有效）：
 *
 *     list  鸡翁、鸡母、鸡雏组合的列表
 *
 * 返回值：
 *
 *      -1 失败
 *
 *      0 成功
 *
 *
 *
 *
 *
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *
 *
 * 示例1
 * 输入：
 * 1
 * 复制
 * 输出：
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        while(scanner.hasNext()){
            num = scanner.nextInt();
            //公鸡最多买20只，母鸡最多买33只，小鸡按价格最多买300只，但实际不能超过100只，实际没有必要单独开一个三层循环遍历小鸡，直接用100-公鸡-母鸡
            for (int i = 0; i <= 20; i++) {
                for (int j = 0; j <= 33; j++) {
                    int k = 100 - i - j;
                    //鸡雏买0只或者大于等于3只
                    if ((k % 3 == 0) && (i * 5 + j * 3 + k / 3 == 100)) {
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
        scanner.close();
    }
}
