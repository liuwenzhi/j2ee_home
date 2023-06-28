package coder.NC127;

/**
 * NC127 最长公共子串
 * 本题核心思路同牛客网 hj65题，按照hj65题超时了，跑完2/3的用例
 */
public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        if(str1.length()>=str2.length()){
            return getCommonStr(str1,str2);
        }else{
            return getCommonStr(str2,str1);
        }
    }

    /**
     * @param line1 长的串
     * @param line2 短的串
     */
    private String getCommonStr(String line1,String line2){
        String common = "";
        //从头往后遍历短的，提取子串，外层for循环找短字符串的左边界，内层for循环找短字符串的右边界
        for(int i=0;i<line2.length();i++){
            for(int j=line2.length();j>i;j--){
                //如果长的包含短的，子串，则满足公共字符串条件，再进行长度判断
                if(line1.contains(line2.substring(i,j))){
                    //只在common比公共子串长度短的时候进行替换
                    if(common.length()<line2.substring(i,j).length()){
                        common = line2.substring(i,j);
                    }
                }
            }
        }
        return common;
    }
}
