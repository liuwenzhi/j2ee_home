package lkhwtk.leetcode1165;

/**
 * 1165. 单行键盘
 * 思路：构建整形数组保存键的位置
 * 二轮修改时优化，旧的思路使用Map保存，效率偏低
 */
public class Solution {
    public int calculateTime(String keyboard, String word) {
        //定义一个整形数组，保存键盘上每个键的实际位置
        int[] key = new int[26];
        for(int i=0;i<keyboard.length();i++){
            //记录下keyword中当前字符实际出现的位置
            key[keyboard.charAt(i)-'a'] = i;
        }
        //位置
        int position = 0;
        //最终结果
        int result = 0;
        for(int i=0;i<word.length();i++){
            result += Math.abs(key[word.charAt(i)-'a']-position);
            position = key[word.charAt(i)-'a'];
        }
        return result;
    }

    public static void main(String[] args){
        String keyword = "abcdefghijklmnopqrstuvwxyz";
        Solution solution = new Solution();
        System.out.println(solution.calculateTime(keyword,"cba"));
    }
}
