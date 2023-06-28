package lkhwtk.leetcode409;

/**
 * 个人思路：比较直接
 */
public class Solution1 {
    public int longestPalindrome(String s) {
        //一步很巧的设计，不用单独设置一个哈希map，直接定义一个整形数组，数组下标对应具体的ASCII码值，和具体字符对应
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        //存在奇数个元素的标识
        boolean flag = false;
        //数量不为0，并且元素出现偶数个，则可以作为回文数字的组成
        for(int i=0;i<count.length;i++){
            if(count[i]!=0&&count[i]%2==0){
                //出现偶数次的字母直接累计到回文字符串中
                ans+=count[i];
            }else if(count[i]!=0&&count[i]%2==1){
                //出现奇数词的字母-1后累计到回文字符串中，同时记录一个存在奇数元素数量的标识
                ans+=count[i]-1;
                flag = true;
            }
        }
        //如果存在奇数的字符，在上一步for循环中统计完成之后，再随机拿出一个作为回文字符串最中间的一个字符
        if(flag){
            ans++;
        }
        return ans;
    }
}
