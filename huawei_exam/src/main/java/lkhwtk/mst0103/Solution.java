package lkhwtk.mst0103;

/**
 * 面试题 01.03. URL化
 * 注意一个点：本题给出了字符串实际长度，但是S中可能在这个长度之后包含了若干个空格，这个时候，长度外的空格不用管，这个是本题的一个坑点
 * 本题同offer05
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        //逐渐遍历字符串
        for (int i = 0; i < length; i++) {
            //如果不是空格就加入到StringBuilder中，如果是空格
            //就把"%20"加入到StringBuilder中
            char ch = S.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
