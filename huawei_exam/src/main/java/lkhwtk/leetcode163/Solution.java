package lkhwtk.leetcode163;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题思路：双指针
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * 注意这个用例：[] 1 1
 * 本题细节非常多，注意下，尤其是编辑，数组中和数组外的判断，可以作为确实空间数组模板
 * Solution1分别处理各个情况，更好理解一点
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        //定义前置指针，注意这里有一个-1是因为nums数组中可能没有lower，但输出要有lower，这么处理最方便
        int pre = lower-1;
        for(int i=0;i<nums.length;i++){
            //数组中元素相差2才有缺失空间
            if(nums[i]-pre==2){
                result.add((pre+1)+"");
            }else if(nums[i]-pre > 2){
                result.add((pre+1)+"->"+(nums[i]-1));
            }
            pre = nums[i];
        }
        //注意：数组里边是>2，外边判断就是大于1了，因为数组里边元素是存在的，外边不存在
        if(upper-pre==1){
            result.add((pre+1)+"");
        }else if(upper-pre > 1){
            result.add((pre+1)+"->"+upper);
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {0,1,3,50,75};
        solution.findMissingRanges(a,0,99);
    }
}
