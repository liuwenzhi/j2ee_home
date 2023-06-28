package lkhwtk.leetcode1371;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用525题map方式存储值，注意和数组处理方式的不同，map单独put一个(0，-1)
 * 相对了Solution，本题的边界更好理解一点，但是效率稍低一点
 */
public class Solution1 {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0, status = 0;
        //如果是一个空字符串，也是满足条件的，这里加一个0位置的value值-1,如果开头的一个字母，不是元音字母，也是满足条件的，所以要进行统计。在32行到35行之间的判断执行
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //基于奇偶性对uoiea这个顺序的字符串进行压缩，1每次左移一定位数，和具体字母对应上，执行一次抑或操作就改变了一次奇偶性
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            //直接判断有没有这个状态值，有的就做差求值，没有就保存位置，当第一次循环，status等于0的时候，map中0的值会被覆盖为0
            if (map.containsKey(status)){
                ans = Math.max(ans, i- map.get(status));
            } else {
                map.put(status,i);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        //System.out.println(solution.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(solution1.findTheLongestSubstring("l"));
    }

}
