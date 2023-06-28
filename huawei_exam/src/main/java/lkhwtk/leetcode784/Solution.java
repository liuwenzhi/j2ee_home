package lkhwtk.leetcode784;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 参考思路：官方
 */
public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c: s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                //每次遍历已有长度的列表，然后在遍历的过程中增加元素，增加的size不在当前for循环中进行遍历
                for (int i = 0; i < n; ++i) {
                    //n记录的是执行下边这个add之前list列表的长度，这里添加了之后，n的长度加1了，此时加入这个元素的编号是n+i，这个添加相当于复制一个当前元素到列表中
                    ans.add(new StringBuilder(ans.get(i)));
                    //每次多一个英文字母，就给n个记录再增加n个记录，前n个记录拼接字母小写，后n个记录拼接字母大写
                    ans.get(i).append(Character.toLowerCase(c));
                    //这个地方比较巧，ans列表并没有设置初始化大小，这里随便扩容
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans) {
            finalans.add(sb.toString());
        }
        return finalans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.letterCasePermutation("a1b2");
    }
}
