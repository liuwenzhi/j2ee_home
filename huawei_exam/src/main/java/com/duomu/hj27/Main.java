package com.duomu.hj27;
import java.util.*;

/**
 * 题目描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述:
 * 先输入单词的个数n，再输入n个单词。
 * 再输入一个单词，为待查找的单词x
 * 最后输入数字k
 * 输出描述:
 * 输出查找到x的兄弟单词的个数m
 * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入
 * 3 abc bca cab abc 1
 * 输出
 * 2
 * bca
 */
public class Main {
    /**
     * 验证兄弟单词的思路：
     * 定义一个包含26个整数的整形数组，str1和str2中包含的字符位置
     * 进行自增和自减操作，如果str1和str2是兄弟单词，那么最终整形数组的值不会改变
     * 这个方式相比于算法中的isBrother的方式时间华为更多，增加了遍历数组的成本
     */
    /*public static boolean checkBorther(String str1, String str2){
        int[] arr = new int[26];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0; i<ch1.length; i++){
            arr[ch1[i]-'a']++;
            arr[ch2[i]-'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }*/

    /**
     * Arrays排序和比较应用非常巧妙
     */
    private static boolean isBrother(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        //排序之后直接比较两个字符数组
        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //输入字典中单词的个数
            int N = scanner.nextInt();
            String[] str = new String[N];
            //输入n个单词作为字典单词
            for(int i=0; i<N; i++){
                str[i]=scanner.next();
            }
            // 查找兄弟单词
            String findStr = scanner.next();//输入一个待查单词
            int ind = scanner.nextInt(); //输入待查单词的 指定序号
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                if((str[i].length() == findStr.length()) && (!str[i].equals(findStr))){
                    //长度相等 且 字符串不相等，这种情况可能是兄弟单词
                    if(isBrother(findStr,str[i])){
                        list.add(str[i]);
                    }
                }
            }
            //输出
            System.out.println(list.size());
            //注意对列表的排序方式实现
            Collections.sort(list);
            if(list.size()>=ind){
                System.out.println(list.get(ind-1));
            }
        }
    }
}
