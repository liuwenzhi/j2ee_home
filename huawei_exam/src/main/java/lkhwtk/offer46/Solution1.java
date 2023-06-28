package lkhwtk.offer46;

/**
 * 使用一维动态规划数组的思路
 * 效率和Solution差不多
 */
public class Solution1 {
    public int translateNum(int num) {
        if(num==0){
            return 1;
        }
        //将num转成字符串类型更容易处理
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        //for循环从i=2开始，实际是num数组的第二位开始，也即：下标为1的位开始。不算附加的0，实际求了1,2...s.length()，一共对s.length()个数字进行了计算
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            //注意String类的compareTo方法，昨天offer45题遇到了，判断当前元素是否可以和前一个元素
            dp[i] = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? dp[i-1] + dp[i-2] : dp[i-1];
        }
        return dp[s.length()];
    }

}
