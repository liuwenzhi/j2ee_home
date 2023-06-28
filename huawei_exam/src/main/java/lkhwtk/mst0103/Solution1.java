package lkhwtk.mst0103;

/**
 * 用jdk工具方法一行代码搞定，先截长度，后替换
 */
public class Solution1 {
    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }
}
