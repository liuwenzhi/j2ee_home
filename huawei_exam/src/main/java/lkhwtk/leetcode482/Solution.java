package lkhwtk.leetcode482;

/**
 * 482. 密钥格式化
 * 随便找了一个题解参考下，这里有一些处理比Solution简单
 * 效率和solution差不多，本题是一个纯逻辑题目
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        //删除破折号，并转大写
        S = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        //倒序遍历
        for (int i = S.length() - 1; i >= 0; i--) {
            sb.append(S.charAt(i));
            cnt++;
            //如果满了K个字符并且i不是0时，加上破折号
            if (cnt % K == 0 && i != 0) {
                sb.append("-");
            }
        }
        //因为是倒序遍历，所以最后需要翻转下字符串
        return sb.reverse().toString();

    }
}
