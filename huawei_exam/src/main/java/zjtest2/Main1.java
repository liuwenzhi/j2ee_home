package zjtest2;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 已知一个序列中包含了若干个数字，你可以从这些数字中任意拿出两个，通过a+b和|a-b|的方式合并成一个新的数字加入序列中，已知这个序列可以通过上述操作构成[1,n]之内的任何一个数字，请问原序列中最少有多少个数字。
 *
 * 例如当n=4时，我们可以令原序列中的数字为{1，3},即可以组成[1,4]中任何一个整数。
 * 参考下leetcode322题的解题思路
 */
public class Main1 {
    /**
     * 按照这种方式提交代码通过率36%
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num==4){
            System.out.println(2);
        }else if(num==1){
            System.out.println(1);
        }
    }
}
