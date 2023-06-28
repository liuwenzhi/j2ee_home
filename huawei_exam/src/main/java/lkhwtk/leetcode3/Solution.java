package lkhwtk.leetcode3;

import java.util.HashMap;

/**
 * 参考题解：滑动窗口
 * 本题核心思路：滑动窗口
 * 2021年10月26日，华为一面原题，下午再看下
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //最大无重复字符串长度
        int max = 0;
        //无重复字符串的左侧边界
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                //如果map集合中存在了已有的字符，则left要么是原来的位置，要么是已被存储的重复字符位置+1，可以这么来考虑这个设计：最开始left位置是0，设计一个无重复字符串的起始位置，
                //以字符串pwwkew为例，i先走，走到2的位置，p和第一个w已经存到了map中，然后出现了第二个w，此时在之前已经统计了left在0位置时的max的情况下，让left走到map中第一
                //个w之后的位置（即第二个w的位置），找到一个新的窗口开始位置，此时相当于从上一个重复元素的下一位置，继续循环往后走，k和e进入map，统计了max值为3了（wke），走
                //到最后一个位置w，这个时候，left需要指向第二个w后一个位置，开启一个新的窗口位置，再统计下窗口值，kew还是3，最终确定无重复字符串值是3。这里用max进行比较取
                //值，对于这种用例：dvdf，left=0，right走到第二个d的时候，需要left从上一个d出现的位置后一个位置开始走，即从v开始往后走。下边取left的时候，增加了一个max求解
                //比如对于这种用例：abba，开始存放a的位置为0，b为1，然后遍历到第二个b的时候，b的位置上变为2，left的值设置为2，a还是0，走到最后一个a的时候，left不能设置为0+1
                //相当于往前移动了，还是2的位置就可以了。abba这种情况相当于使用Map思路的一个特殊情况。
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            //每次更新窗口最大宽度
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abba");
    }
}
