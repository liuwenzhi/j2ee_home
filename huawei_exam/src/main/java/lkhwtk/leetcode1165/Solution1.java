package lkhwtk.leetcode1165;

/**
 * 这个算法比Solution慢1ms
 */
public class Solution1 {
    public int calculateTime(String keyboard, String word) {
        //位置
        int position = 0;
        //最终结果
        int result = 0;
        for(int i=0;i<word.length();i++){
            int index = keyboard.indexOf(word.charAt(i));
            result += Math.abs(index-position);
            position = index;
        }
        return result;
    }

    public static void main(String[] args){
        String keyword = "abcdefghijklmnopqrstuvwxyz";
        Solution1 solution = new Solution1();
        System.out.println(solution.calculateTime(keyword,"cba"));
    }
}
