package lkhwtk.Offer_58_I;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基于双向链表实现
 */
public class Solution2 {
    public String reverseWords(String s) {
        Deque<String> words = new LinkedList<>();
        for (String word : s.split("\\s+")) {
            //拆分出来的每一个单词，都放到链表的头部，再输出正好是倒序
            words.addFirst(word);
            //这种就是正序
            //words.add(word);
        }
        /*while(!words.isEmpty()){
            System.out.println(words.poll());
        }*/
        //在字符串结尾有一个空格，join可以处理掉，但是有多个空格只能处理一个，这里加了一个trim处理
        return String.join(" ", words).trim();
    }
    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverseWords("the sky is blue"));
    }
}
