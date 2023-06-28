package com.duomu.hj13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 基于双向列表实现，每次都把拆分出来的单词放到链表头部，然后再从头遍历链表的时候得到的就是逆序的句子
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> words = new LinkedList<>();
        for (String word : scanner.nextLine().split("\\s+")) {
            //拆分出来的每一个单词，都放到链表的头部，再输出正好是倒序
            words.addFirst(word);
        }
        /*注意：本题是在while循环之外做输出，本地测试时可以通过在输入的下一行输入ctrl+d组合键
        (可能需要关闭输入法)实现退出scanner这个判断循环，得到结果输出*/
        System.out.println(String.join(" ", words));
    }
}
