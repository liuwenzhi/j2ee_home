package lkhwtk.leetcode1400;

/**
 * 1400. 构造 K 个回文字符串
 * 本题名字上是构造回文字符串，实际上和回文字符串设计没有太大关系，注意一个点：用s的所有字符构造出k个
 * 回文字符串，一定是把s的所有字符都用上去构造k个，所以s至少可以构造出s.length个回文字符串，这是构造回
 * 文字符串次数的上界，最大能够造出这么多。
 * 参考题解：官方，核心思路：找到s能够造出的最小回文字符串次数和最大次数，判断k是否在最小次数和最大次数之间
 * 本题证明过程不用看，记下结论。
 * 比如true这个数字，上界是4，下界也是4（出现奇数次字母的个数），回文字符串只能t r u e这四个单独字符。
 * 如果是truee这个数字，上界是5，下界是3（出现奇数次字母的个数），3个回文数包括：ete,r,u或者ere,t,u或者eue,r,t
 * 构造4个回文数包括：ee,t,r,e
 */
public class Solution {
    public boolean canConstruct(String s, int k) {
        //开头加一个基本的判断，能节省1ms
        if(k>s.length()){
            return false;
        }else if(k==s.length()){
            return true;
        }
        // 右边界为字符串的长度，即上界
        int right = s.length();
        // 统计每个字符出现的次数
        int[] occ = new int[26];
        for (int i = 0; i < right; ++i) {
            ++occ[s.charAt(i) - 'a'];
        }
        // 左边界为出现奇数次字符的个数
        int left = 0;
        for (int i = 0; i < 26; ++i) {
            if (occ[i] % 2 == 1) {
                ++left;
            }
        }
        // 注意没有出现奇数次的字符的特殊情况，赋值为1
        left = Math.max(left, 1);
        //最终次数满足左右边界即可
        return left <= k && k <= right;
    }
}
