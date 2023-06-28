package lkhwtk.leetcode228;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 官方题解，效率更高
 * 重点注意内层while循环，实际是有效减少了外层循环，并且没有把时间复杂度提高
 * 类似本题这种：while一层循环，内层套一个while循环，然后通过同一个变量来控制循环信息，实际不增加复杂度的设计后边参考下，之前也遇到过类似的
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            //把连续的都拿过来
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            //高位是i-1，补一下最后一次i自增之后不满足上边while循环条件的情况
            int high = i - 1;
            //先把low拼过来
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            //如果low小于high，再拼一个箭头
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;

    }
}
