package lkhwtk.offer46;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 本题和91题有一点类似，都是数字转字母，但是本题是从0开始编，91题从1开始，这一点就有很大的不同
 * 参考题解：面试题46. 把数字翻译成字符串（动态规划，清晰图解）
 * 本题推理 dp[0]这个思路很好，之前个人建立动态规划思路的时候，一直没有反推的思路
 * 本题不需要建立一维规划数组，因为dp[i]最多之和dp[i-1] dp[i-2]相关，直接用两个
 * 变量保存dp[i-1]和dp[i-2]即可
 * 下边这个题解也不错：深入理解 动态规划 DP+递归
 * 配合看下，比对下动态规划和递归
 */
public class Solution {
    public int translateNum(int num) {
        if(num==0){
            return 1;
        }
        //将num转成字符串类型更容易处理
        String s = String.valueOf(num);
        //a代表dp[i-1]，b代表dp[i-2]
        int a = 1, b = 1;
        //for循环从i=2开始，实际是num数组的第二位开始，也即：下标为1的位开始。不算附加的0，实际求了1,2...s.length()，一共对s.length()个数字进行了计算
        for(int i = 2; i <= s.length(); i++) {
            //注意：substring是前包含，后不包含，所以这里for循环是i<=s.length，实际起始位置是dp[1]，
            //用a代表，dp[0]用b代表，循环算法从dp[2]开始，后边用a代表dp[i-1]，b代表dp[i-2]
            String tmp = s.substring(i - 2, i);
            //注意String类的compareTo方法，昨天offer45题遇到了，判断当前元素是否可以和前一个元素
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
