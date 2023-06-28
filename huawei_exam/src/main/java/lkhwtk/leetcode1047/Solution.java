package lkhwtk.leetcode1047;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 参考题解：删除字符串中的所有相邻重复项 官方
 * 本题题解的动态效果可参考这个：1047. 删除字符串中的所有相邻重复项【栈的经典应用】详解
 * 本题和1209题存在一定相似性
 */
public class Solution {

    /**
     * 用stringBuilder简单模拟下栈，定义一个top指针位置，指向stringBuilder的最后一个位置，
     * 然后每次从top指针的位置插入或者删除掉重复元素即可
     */
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        //top定义为-1，这个设计非常巧妙，top起到一个类似指针的作用指向stringBuilder对象最新的位置
        int top = -1;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(top>=0&&stringBuilder.charAt(top)==c){
                stringBuilder.deleteCharAt(top);
                top--;
            }else{
                stringBuilder.append(c);
                top++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){

    }
}
