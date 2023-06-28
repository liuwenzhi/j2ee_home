package lkhwtk.leetcode278;

/**
 * 278. 第一个错误的版本
 * 直接遍历会超时
 */
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        for(int i=1;i<=n;i++){
            if(isBadVersion(i)==true){
                return i;
            }
        }
        return 0;
    }
}
