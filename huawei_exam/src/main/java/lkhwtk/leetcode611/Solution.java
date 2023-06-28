package lkhwtk.leetcode611;

import java.util.Arrays;

/**
 * 参考题解：
 * 官方题解：证明数组排序之后：a+b>c 即可满足是三角形的证明参考下，a<b<c，一定有：a+c>b，b+c>a，只需要在算法中搞定a+b>c
 * 官方题解在算法说明上不清晰，8月3号重新发布一次说明，依然说不透彻。
 * 参考题解：明确条件进行求解
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //算法中要验证是否有：a+b>c，则从后往前，每次固定最大的边，找前边有一个满足条件的小边
        for (int i = n - 1; i >= 2; --i) {
            //最大边固定好之后，找前边的集合的左右边界
            int l = 0, r = i - 1;
            //注意：这里边界不能重合，一定是l<r
            while (l < r) {
                //如果l位置元素值+r位置元素值大于nums[i]，则一定有l到r-1位置的元素和num[r]的和都大于nums[i]，统计数量
                if (nums[l] + nums[r] > nums[i]) {
                    //注意：这里统计的数量是r-l，nums[l]组合nums[r],nums[l+1]组合nums[r]...nums[r-1]组合nums[r],数量是(right-1)-left+1=r-l
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }
}
