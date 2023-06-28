package lkhwtk.leetcode316;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 316. 去除重复字母
 * 本题和402题思路类似，个人参考到402题思路，实现效率偏低
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        //记录s中每一个字符出现的次数
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        //将s中每一个字符出现的次数都放到map数组中
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; ++i) {
            char letter = s.charAt(i);
            int k = map.get(letter);
            //队列里边没有letter的时候再往里放
            if(!deque.contains(letter)){
                //获取队尾元素和letter比较，如果比letter大（按照字典顺序大），同时队尾元素存在重复，则队尾元素出栈
                while (!deque.isEmpty() && deque.peekLast() > letter && map.get(deque.peekLast()) >0) {
                    deque.pollLast();
                }
                //新元素入队尾
                deque.offerLast(letter);
            }
            //map中letter次数-1，主要是进行while循环的判断，这里不用考虑是否从map中删除这个key，只要数值满足条件即可
            map.put(letter,k-1);
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }
        return result.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.removeDuplicateLetters("bcabc");
    }
}
