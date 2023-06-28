package lkhwtk.leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution2的另一种写法,这么写比Solution慢了1ms
 */
public class Solution3 {
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
        //通过滑动窗口，左边减一个，右边加一个，判断是否满足条件
        for(int i = 1; i < n-m+1; i++){
            //初始为第一位0，去掉这一位
            sCnt[s.charAt(i - 1) - 'a']--;
            //初始为p的长度，m位，增加这一位
            sCnt[s.charAt(i+m-1) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                //for循环中如果初始满足条件，则在res中添加第一位
                res.add(i);
            }
        }
        return res;
    }
}
