package com.duomu.hj36;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.ArrayList;
/**
 * 题目描述
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 * 备注：第二行实际也是26个英文字母，只是顺序和第一行不一样了
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 *
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 *
 * 本题有多组输入数据。
 *
 * 输入描述:
 * 先输入key和要加密的字符串
 *
 * 输出描述:
 * 返回加密后的字符串
 *
 * 示例1
 * 输入
 * 复制
 * nihao
 * ni
 * 输出
 * 复制
 * le
 */
public class Main {
    /**
     * 注意本题的一个坑点：要加密的字符串可能包括大写字母，可能包括小写字母。秘钥可能是包含大小写字母，但是实际没啥大的影响。
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //秘钥，对秘钥转成大写字母，秘钥可能包含大小写字母，但是实际没啥大的影响
            String s1 = scanner.nextLine().toUpperCase();
            //要加密的字符串
            String s2 = scanner.nextLine();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            //LinkedHashSet保证顺序，同时去重，set集合先以字符形式放入放入秘钥，存入的字符都是大写字母，注意这里不能使用TreeSet，TreeSet会对结果进行排序
            LinkedHashSet<Character> set = new LinkedHashSet();
            //LinkedHashSet存放秘钥，在开头几位，都是大写字母
            for (int i = 0; i < chars1.length; i++) {
                set.add(chars1[i]);
            }
            int k = 0;
            //set集合放入秘钥之后，再放入其他字母，也都是大写的字母，LinkedHashSet能直接去重
            while (set.size() < 26) {
                char a = (char) ('A' + k);
                set.add(a);
                k++;
            }
            //将LinkedHashSet转成ArrayList,都是有序的直接转一下，LinkedHashSet没有单独的get方法，获取集合中元素需要用迭代器
            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] == ' ') {
                    //空字符结果拼一个空
                    sb.append(chars2[i]);
                } else if (chars2[i] < 'a') {
                    //等待加密的字符串中字母都是大写字母的情况
                    int n = chars2[i] - 'A';
                    char c = list.get(n);
                    sb.append(c);
                } else {
                    //对于小写字母，取到对应的大写秘钥字母之后，再转成小写的
                    int n = chars2[i] - 'a';
                    char c = (char)(list.get(n)+'a'-'A');
                    sb.append(c);
                }

            }
            System.out.println(sb.toString());
        }
    }
}
