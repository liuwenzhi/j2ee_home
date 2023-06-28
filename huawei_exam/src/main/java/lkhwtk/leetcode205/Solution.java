package lkhwtk.leetcode205;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * 参考题解：官方。本题个人开始理解有误，以为s中的每一个字符，必须按照同种规则映射到t中的字符，
 * 比如abb~cdd，a映射到c增加2，b映射到d增加2，实际是：s和t的每一个位置上的字符都能一一对应，
 * 没有什么累加的映射关系，比如a对应c，那么从头到尾都是a和c对应，a和c不能对应其它值
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            //遍历s和t，取出每一个位置上的元素
            char x = s.charAt(i), y = t.charAt(i);
            //如果s2t包含了key=x，同时val不是y，或者t2s包含了key=y，同时val不是x，那么就是对应不上
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            //s2t存s到t上每一个元素的映射
            s2t.put(x, y);
            //t2s存t到s上每一个元素的映射
            t2s.put(y, x);
        }
        return true;
    }
}
