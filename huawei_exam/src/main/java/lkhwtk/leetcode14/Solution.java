package lkhwtk.leetcode14;
/**
 * 14. 最长公共前缀
 * 思路：取数组中第一个字符串，然后找第二个字符串和第一个字符串的公共前缀，
 * 拿到这个前缀结果信息，再去和第三个字符串匹配，以此类推
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String commonPrefix = strs[0];
        for(int i=1;i<strs.length;i++){
            //找公共前缀使用字符串的startsWith是一个很巧的方式，同时注意这个while循环，每次砍掉最后一个字符，
            //如果字符串一直不包含前缀，前缀最后截成一个空字符串，这个时候肯定会包含
            while(!strs[i].startsWith(commonPrefix)){
                commonPrefix = commonPrefix.substring(0,commonPrefix.length()-1);
            }
            //如果数组中前边的数据已经没有公共前缀了，则不用继续循环了
            if("".equals(commonPrefix)){
                break;
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] a = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(a));

    }
}
