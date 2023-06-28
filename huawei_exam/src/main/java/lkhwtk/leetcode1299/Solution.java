package lkhwtk.leetcode1299;

/**
 * 1299. 将每个元素替换为右侧最大元素
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：      [18,6,6,6,1,-1]
 * 解释：
 * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 * 本算法非常重技巧
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        //创建结果数组
        int[] ans = new int[length];
        //从ans的倒数第二个值开始赋值，最后一个元素值置为-1
        for(int i=length-2;i>=0;i--){
            //arr[i + 1]是当前元素下一个值，ans[i+1]是当前元素下一个元素之前的最大值，这俩一比较就是当前元素右侧最大值，这个设计太巧妙了
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        ans[length-1] = -1;
        return ans;
    }

    public static void main(String[] args){

    }
}
