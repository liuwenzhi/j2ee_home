package lkhwtk.leetcode771;

/**
 * 对Solution进行优化，用大小写字母数组替换Map集合，实际没有明显的效率提升。
 */
public class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        int length1 = jewels.length();
        int length2 = stones.length();
        int result = 0;
        //定义一个宝石小写字母和大写字母集合
        int[] jewelsSetSmall = new int[26];
        int[] jewelsSetBig = new int[26];
        for(int i=0;i<length1;i++){
            char c = jewels.charAt(i);
            if(c>='a'&&c<='z'){
                //小写字母的情况
                jewelsSetSmall[c-'a']++;
            }else{
                //大写字母的情况
                jewelsSetBig[c-'A']++;
            }
        }
        for(int i=0;i<length2;i++){
            char c = stones.charAt(i);
            if(c>='a'&&c<='z'&&jewelsSetSmall[c-'a']>0||c>='A'&&c<='Z'&&jewelsSetBig[c-'A']>0){
                result++;
            }
        }
        return result;
    }
}
