package lkhwtk.leetcode58;

/**
 * 纯字符串逻辑处理，效率更高一点
 */
public class Solution1 {
    public int lengthOfLastWord(String s) {
        //end标识字符串最后一个单词结束位置
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        if(end < 0){
            return 0;
        }
        //start标识字符串最后一个单词开始位置的前一个位置，注意一个细节点：end的位置是最后一个单词的结束位置，start的位置是最后一个单词的前一个位置，start到了空格位置
        //所以最终返回的是end - start，如果start指向一个单词的开始位置，end指向结束位置，那么单词实际长度是end-start+1
        int start = end;
        while(start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end - start;
    }

}
