package lkhwtk.leetcode791;

/**
 * 791. 自定义字符串排序
 */
public class Solution {
    public String customSortString(String order, String str) {
        //将str中每一个字符出现的次数放到count整形数组中,str中可能存在多个字符（其中有重复的）能和order中的字符匹配上
        int[] count = new int[26];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            count[c-'a']++;
        }
        //遍历order列表，将count中可能包含的多个order字符拼到stringBuilder中
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            while(count[c-'a']>0){
                //拼接一次，count中该字符的值做一次递减
                stringBuilder.append(c);
                count[c-'a']--;
            }
        }
        //将剩余的字符拼接到stringBuilder中
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            while(count[c-'a']>0){
                //拼接一次，count中该字符的值做一次递减
                stringBuilder.append(c);
                count[c-'a']--;
            }
        }
        return stringBuilder.toString();
    }
}
