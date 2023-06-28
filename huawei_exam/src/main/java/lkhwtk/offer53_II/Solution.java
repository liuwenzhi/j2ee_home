package lkhwtk.offer53_II;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 本题采用折半效率应该会更高，测试用例中直接遍历查找和折半没啥差别
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            //如果total和nums[i]不等，则此时total为确实元素
            if(total<nums[i]){
                break;
            }
            total +=1;
        }
        return total;
    }
}
