package lkhwtk.leetcode75;

/**
 * 参考题解：颜色分类 官方
 * 思路：两次遍历数组，第一次把0都换到前边，第二次把1都换到0的后边，2的位置自然就是最右边
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        //把0都换到前边
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                //每次移动完之后，ptr位置自增，第一次遍历结束之后，正好指向最后一个0的下一个位置
                ++ptr;
            }
        }
        //把1都换到前边
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
