package lkhwtk.mst0803;

/**
 * 面试题 08.03. 魔术索引
 * 本题二轮复习直接过
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==nums[i]){
                return i;
            }
        }
        return -1;
    }
}
