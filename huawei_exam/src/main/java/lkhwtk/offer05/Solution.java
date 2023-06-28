package lkhwtk.offer05;

/**
 * 剑指 Offer 05. 替换空格
 * 注意：本题特点是有几个空格就替换几个"%20"
 * 直接replaceAll也可以，时间效率不高
 * 本题同 面试题 01.03
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
