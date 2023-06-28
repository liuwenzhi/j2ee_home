package lkhwtk.leetcode153;

/**
 * 参考题解：官方
 * 二分查找法，这个思路拿一个数组走几遍就清晰了，最后low的位置就是最小值
 * 注意：使用二分查找法的前提：数组有序，本题中数组起码能保证是部分有序的
 * 如果数组中有重复的元素，这种方式不太适合。那种方式可以看下本题的视频，154题不带有重复元素，但不是华为题库范围。
 * 视频题解：简单易懂 Java/C++ / Python/js【培养算法思维】- 旋转数组最小值
 * 题解中对low < high这个条件，还有high = pivot这块讲得也比较含糊
 * 本题和33题采用了两种二分查找的写法，33题是找一个指定的值，本题找最小值。
 * 疑点参考题解：二分查找：为什么左右不对称？只比较mid与right的原因（C++, Java, Python3）
 */
public class Solution1 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //注意条件一定是low<high，不包括high，保证搜索空间中一定有一个元素，在搜索结束的时候，空间中一定有一个元素，这个和常见的二分查找比如33题的设计不太一样
		//可以这么来理解：除了最小值在最右端之外，其他时候只有在区间长度为1的情况下nums[pivot]才能等于nums[high]，而最小值在最右端的情况，实际也是走到区间为1的
		//时候才会出现nums[pivot]==nums[high]，以上情况都是算法已经执行完了，拿到了最终的结果，所以过程中肯定不会出现nums[pivot] == nums[high]的情况
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                //注意high = pivot，而不是pivot-1，中间值可能是要查找的值，这个地方可以参考下视频题解：简单易懂 Java/C++ / Python/js【培养算法思维】- 旋转数组最小值
                //里边的视频：2. 二分查找，假设数组不存在重复元素，讲得也有点含糊，可以参考下
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        //最后返回low和high位置的元素都可以，如果能拿到最后一次pivot也可以，
        //经过二分查找，最后high，low和pivot三个指针重合
        return nums[low];
    }
}
