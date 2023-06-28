package lkhwtk.leetcode1239;

import java.util.ArrayList;
import java.util.List;
/**
 * 参考思路：官方
 * 迭代+位运算
 * 迭代就是遍历每一个元素
 */
public class Solution1 {
    public int maxLength(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        for (String s : arr) {
            //mask含义和Solution一致
            int mask = 0;
            //判断单个字符串是否有重复字母，思路都和Solution一致
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            //此时遍历的入参当前字符串有重复字母，继续
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            //遍历masks数组，然后遍历每一个元素，和当前mask做比较，看是否有公共元素，没有就拼到一块，加入到队列中，
            //再统计最大长度，遍历每一个入参的同时，再遍历全部前缀字符串，注意最开始masks中加入了一个0，所以后边的
            //字符串不一定要和入参的字符串拼接，可以直接作为头。方法思路确实很好，效率稍微低一点
            for (int i = 0; i < n; ++i) {
                int m = masks.get(i);
                if ((m & mask) == 0) { // m 和 mask 无公共元素
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        List<String> arr = new ArrayList<>();
        arr.add("st");
        arr.add("str");
        Solution1 solution = new Solution1();
        System.out.println(solution.maxLength(arr));
    }

}
