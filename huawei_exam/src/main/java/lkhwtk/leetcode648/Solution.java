package lkhwtk.leetcode648;

import java.util.List;

/**
 * 648. 单词替换
 * 个人思路
 * 本题题解中有构造前缀树和字典树的方式求解，不比本人的思路好多少，按照自己思路来吧
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence==null||sentence.length()==0){
            return sentence;
        }
        String[] cache = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s:cache){
            //提示中提到字典中每个单词最大长度100，这里初始化一个101就代表了最大的
            int length = 101;
            String temp = null;
            for(String dict:dictionary){
                if(s.startsWith(dict)&&dict.length()<length){
                    temp = dict;
                    length = dict.length();
                }
            }
            //针对于当前单词，如果匹配不到字典中的词，就在结果中拼接原词
            if(temp==null){
                //提示中提到，sentence中每个单词之间间隔一个空格
                stringBuilder.append(s).append(" ");
            }else{
                //如果能匹配上，就拼接字典
                stringBuilder.append(temp).append(" ");
            }
        }
        //返回结果trim一下，把最后一个空格去掉
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String a = "abcd";
        String b = "ab";
        System.out.println(a.startsWith(b));
    }
}
