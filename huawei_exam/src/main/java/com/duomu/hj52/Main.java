package com.duomu.hj52;

import java.util.Scanner;

/**
 * 题目描述
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * 编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
 * Ex：
 * 字符串A:abcdefg
 * 字符串B: abcdef
 * 通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 * 请实现如下接口
 * /*  功能：计算两个字符串的距离
 *  *  输入： 字符串A和字符串B
 *  *  输出：无
 *  *  返回：如果成功计算出字符串的距离，否则返回-1
         *public static   int calStringDistance(String charA,String charB)
        *{
        *return 0;
        *}
        *输入描述:
        *输入两个字符串
        *
        *输出描述:
        *得到计算结果
        *
        *示例1
        *输入
        *abcdefg
        *abcdef
        *输出
        *1
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String strA = in.next();
            String strB = in.next();
            //插入字符次数insert cost统计
            int ic = 1;
            //删除字符次数delete cost统计
            int dc = 1;
            //替换字符次数replace cost统计
            int rc = 1;
            int cost = strEditCost(strA, strB, ic, dc, rc);
            System.out.println(cost);
        }
        in.close();
    }
    public static int strEditCost(String strA, String strB, int ic, int dc, int rc){
        /* 字符串之间的距离，编辑距离，将strA编辑成strB所需的最小代价
         * 编辑操作包括插入一个字符、删除一个字符、替换一个字符
         * 分别对应的代价是ic、dc、rc，insert cost、delete cost、replace cost
         * strA[x-1]代表strA的第x个字符，注意下标是从0开始的,strA[y-1]代表strA的第y个字符
         * 定义一个代价矩阵为(M+1)*(N+1)，需要从前0个字符开始定位，M N 表示strA strB的长度
         * dp[x][y]表示strA的前x个字符串编辑成 strB的前y个字符所花费的代价，一定注意：x变成y，掌握这个前提下边几点就很好理解了
         * dp[x][y]是下面几种值的最小值：
         * 1、dp[x][y] = dp[x-1][y] + dc
         * dp[x-1][y]将strA的前x-1个字符编辑成strB的前y个字符的代价已知，
         * 那么将将strA的前x个字符编辑成strB的前y个字符的代价dp[x][y]就是dp[x-1][y] + dc，这里dc即删除一个x的字符的代价，x的字符多了，y不变，x变成y则需要减一个字符的距离
         * 相当于strA的前x-1个字符编辑成strB的前y个字符，现在变成了strA的前x个字符，增加了一个字符，要加上删除代价
         * 2、dp[x][y] = dp[x][y-1] + ic
         * dp[x][y-1]将strA的前x个字符编辑成strB的前y-1个字符的代价已知，
         * 现在变为strB的前y个字符，相应的在strA前x个操作代价的基础上插入一个字符，x不变，y多了一个字符，x变成y则需要增加一个字符的距离
         * 3、dp[x][y] = dp[x-1][y-1]
         * dp[x-1][y-1]将strA的前x-1个字符编辑成strB的前y-1个字符的代价已知，
         * strA的第x个字符和strB的第y个字符相同，strA[x-1] == strB[y-1]，没有引入操作
         * 4、dp[x][y] = dp[x-1][y-1] + rc
         * strA的第x个字符和strB的第y个字符不相同，strA[x-1] ！= strB[y-1]，
         * 在strA的前x-1个字符编辑成strB的前y-1个字符的代价已知的情况下，
         * 计算在strA的前x字符编辑成strB的前y个字符的代价需要加上替换一个字符的代价
         * 最后做一下1、2和3或1、2和4三种情况的比对，哪一个代价最小
         * */
        int m = strA.length();
        int n = strB.length();
        int[][] dp = new int[m + 1][n + 1];
        //构建的二维数组第一行赋值
        for (int i = 1; i <= n; i++) {
            //第一行：x不变，y增加，x需要增加插入元素的距离
            dp[0][i] = i*ic;
        }
        //构建的二维数组第一列赋值
        for (int i = 1; i <= m; i++) {
            //第一列：y不变，x增加，x需要增加删除元素的距离
            dp[i][0] = i*dc;
        }
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                //str1减少当前字符和str2匹配
                int cost1 = dp[x-1][y] + dc;
                //str1增加当前字符和str2匹配
                int cost2 = dp[x][y-1] + ic;
                int cost3 = 0;
                if(strA.charAt(x-1) == strB.charAt(y-1)) {
                    //strA的第x位置和strB第y个位置值相等
                    cost3 = dp[x - 1][y - 1];
                } else {
                    //strA的第x位置和strB第y个位置值不等
                    cost3 = dp[x - 1][y - 1] + rc;
                }
                dp[x][y] = Math.min(cost1, cost2);
                dp[x][y] = Math.min(dp[x][y], cost3);
            }
        }
        return dp[m][n];
    }

}
