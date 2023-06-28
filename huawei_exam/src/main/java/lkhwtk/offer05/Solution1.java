package lkhwtk.offer05;

/**
 * 通过空字符进行判断，替换为%20，时间效率能达到最高
 */
public class Solution1 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') {
                res.append("%20");
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
