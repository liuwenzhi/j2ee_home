package lkhwtk.leetcode442;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 参考解析：[数组中重复的数] 简单标记:O(1)空间复杂度 Python
 * 思路：以题取巧，通过相反数来判断
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //获取nums[i]这个位置的元素值，如果这个元素值大于0，将这个值置为相反数，既能保留原值进行计算（取绝对值），又能进行判断是否重复
            int num = nums[Math.abs(nums[i])-1];
            if(num>0){
                //将对应nums[i]下标的元素置为相反数
                nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*(-1);
            }else{
                //如果发现nums[Math.abs(nums[i])-1]位置的数据为负，则证明重复过，即：之前有被标记过，nums[i]满足条件
                list.add(Math.abs(nums[i]));
            }
        }
        return list;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int a[] = {4,3,2,7,8,2,3,1};
        List<Integer> list = solution.findDuplicates(a);
        list.forEach(i->{
            System.out.println(i);
        });
    }
}
