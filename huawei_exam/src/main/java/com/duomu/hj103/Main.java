package com.duomu.hj103;

import java.util.Scanner;
/**
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 本题含有多组样例输入
 *
 *
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 输出结果
 *
 * 示例1
 * 输入
 * 复制
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出
 * 复制
 * 3
 * 1
 * 说明
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 *
 * 通过动态规划的方式构建的dp数组是：1 2 1 2 2 3，基于前边已有的数值进行判断和+1计算
 */
//注意：103题的坑点在于：如果选择了一个起始的格子，则只能从这个格子开始往后走，前边的不能走，然后从低往高走。
public class Main {
    /**
     * 本题核心内容是求最整个数组的大递增子序列，和hj24题，leetcode300题思路一致
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            //a[i]接收具体的数据记录
            int[] a = new int[n];
            //通过动态规划方式构建dp数组，dp[i]表示以第i个桩为结尾，最多走多少步，初始是1步（默认这个桩是跟它之前相比最矮的）
            int[] dp = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0 ; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(a[j] < a[i]){
                        /*如果第i个桩前面有比它矮的（比如是j），且以第j个桩为结尾走的步数是最多的，
                           步数就是dp[j]+1，加的这个1表示从第j个走1步到第i个桩；另一种就是dp[i],默认等于1，但是
                           遍历j的过程可能会更新这个值，因此取上述两个结果中最大的那个值，表示第i个桩为结尾，最多走多少步
                        */
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
            }
            //初始化一个max为1，然后遍历dp数组得到一个最大的距离值
            int max = 1;
            for(int i = 0; i < n; i++){
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
