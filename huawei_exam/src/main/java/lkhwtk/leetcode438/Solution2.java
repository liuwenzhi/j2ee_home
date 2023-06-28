package lkhwtk.leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对Solution1的优化
 */
public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        //初始数组满足条件就在结果集中添加0
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        //通过滑动窗口，左边减一个，右边加一个，判断是否满足条件，注意：这里的i是滑动窗口的右侧边界，不是左侧
        for(int i = m; i < n; i++){
            //初始为第一位0，去掉这一位
            sCnt[s.charAt(i - m) - 'a']--;
            //初始为p的长度，m位，增加这一位
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                //for循环中如果初始满足条件，则在res中添加第一位
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
