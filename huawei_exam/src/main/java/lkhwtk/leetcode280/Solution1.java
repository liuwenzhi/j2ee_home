package lkhwtk.leetcode280;

/**
 * 对Solution方案的优化，前后两个元素比较，按照小大小大这种顺序，
 * 不满足条件就互换，本算法思路看起来很简单，实际涉及到很复杂的逻辑，主要问题点：相邻的两个元素不断交换，为什么不会导致换完了产生非摆动排序的情况？
 * 简单梳理下：比如元素为0,1,2,3,4,5,6
 * 0比1小，不交换，1比2小，需要交换，交换完了之后，1这个位置变成了2，比原来的1还大，肯定满足比0大的条件，此时数组变成了：0,2,1,3,4,5,6
 * 然后再往后：1比3小，不交换，3比4小，交换，数组变成0,2,1,4,3,5,6，原来的3比1大，现在换过来一个更大的4，肯定比1大，按照这种顺序可以往下推：0,2,1,4,3,6,5
 * 再比如数组：0 1 4 5 6 2 3
 * 基于上边的推理：可以先转换换成0 4 1 5 6 2 3，接下来转换成：0 4 1 6 5 2 3，然后需要交换5和2，因为5比2大，6 5 之后需要两个递增的数字，交换5和2
 * 因为5本来就比6小，2比5还小，那么2肯定比6小，所以直接交换没问题。
 * 本题解算法绝对经过严密的测试。
 */
public class Solution1 {
    public void wiggleSort(int[] nums) {
        //less是当前摆动大小的标志位，true表示前一个元素比后一个元素小，false代表前一个元素比后一个元素大，每一次循环之后都改变
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] a = {0,1,4,5,6,2,3};
        Solution1 solution1 = new Solution1();
        solution1.wiggleSort(a);
        for(int i:a){
            System.out.print(i+" ");
        }
    }

}
