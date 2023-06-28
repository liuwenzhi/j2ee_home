package lkhwtk.leetcode283;

/**
 * 参考题解：动画演示 283.移动零 精选
 * 这个思路比Solution好理解一点，实际一个意思。这个最好参考下动图或者自己画一个数组移动下，前边的j指针在算法中一直指向0的位置
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j，j在前边指向0，i在后边找非0的
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
