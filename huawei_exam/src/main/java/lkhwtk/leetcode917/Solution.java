package lkhwtk.leetcode917;

/**
 * 917. 仅仅反转字母
 * 二轮复习本题可以略过
 */
public class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        //将s中的字母倒序存入到replace字符串中
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                stringBuilder.append(c);
            }
        }
        String replace = stringBuilder.toString();
        int index = 0;
        StringBuilder result = new StringBuilder();
        //遍历字符串进行赋值
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                result.append(replace.charAt(index));
                index++;
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
}
