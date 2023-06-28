package lkhwtk.leetcode1456;

/**
 * 对Solution的优化，先统计出前k个字母中原因字母个数，然后采用滑动窗口的方式，每次向后走一步，
 * 判断出窗口的元素是不是元音字母，进窗口的元素是不是原因字母，做个处理即可。
 */
public class Solution1 {
    public int maxVowels(String s, int k) {
        int max = 0;
        int num = 0;
        for(int i=0;i<k;i++){
            char c = s.charAt(i);
            if(isVowels(c)){
                num++;
            }
        }
        max = num;
        //注意s的边界
        for(int i=1;i<s.length()-k+1;i++){
            if(isVowels(s.charAt(i-1))){
                num--;
            }
            //注意长度为k的字符串的末尾元素位置
            if(isVowels(s.charAt(i+k-1))){
                num++;
            }
            max = Math.max(max,num);
        }
        return max;
    }

    /**
     * 判断一个字母是不是元音字母
     */
    private boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
}
