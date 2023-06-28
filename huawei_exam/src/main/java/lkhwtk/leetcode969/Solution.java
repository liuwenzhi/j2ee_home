package lkhwtk.leetcode969;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 * 参考题解：官方
 * 参考题解：粗俗易懂：思路借助额外的数据结构：数组 来协助解决问题
 * 煎饼排序的核心思路就是：每次找到最大的元素，经过两次翻转：一次到最前边，一次到最后边
 * 最大元素搞定之后，再按照同样套路搞其他n-1个元素。
 * 重点参考第二个题解，处理得很巧妙。翻转最大的特点就是，能把指定位置元素弄到最前边，然后
 * 可以从最前边弄到最后边。
 */
public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int len = arr.length;
        List<Integer> result = new ArrayList<>();
        if (len < 2) {
            return result;
        }
        // 根据题目给定范围，数组元素的值是在1 到 len 之间的，所以可以用另外一个数组记录每个元素所在的位置，
        // 下标为元素，值为元素所在原数组的位置，这个设计能和题目中的k对应上，初始化数组长度len+1，0位没有arr数组中对应的值不管
        int[] record = new int[len + 1];
        for (int i= 0; i < len; i++){
            record[arr[i]] = i;
        }
        // 这样record数组下标也就是有序的了，我们先从最大的元素开始，一个个的调整到合适的位置
        for (int i = len; i >= 1; i--){
            // 如果当前最大元素的在合适的位置，就不做处理，直接操作下一个，注意record[i]是i这个元素在原数组中的位置的值，
            // 原数组存储元素是0到len-1，record中有效数据存储在位置1到len上，0这个位置是一个默认值，这个细节绝对不能差
            if (i == record[i] + 1) {
                continue;
            }
            // 当前最大元素所在位置
            int curPosition = record[i];

            // 每个元素需继续两步翻转：
            //      第一步：翻转到0位置；
            //      第二步：再翻转到当前最后的位置(i - 1)
            // 首先看是否在0的位置，是的话省去第一步
            if (curPosition == 0){
                //arr数组中从0翻转到i-1的位置，实际翻转的位置是i
                result.add(i);
                //直接整体翻转一遍，此时右侧是当前最大位置，翻转arr数组，修改record数组记录的元素值
                swap(arr, record, 0, i - 1);
            }else {
                // 第一步：将剩余的最大值从某个位置翻转到0位置，注意位置值为record[i]+1,0到record[i]
                result.add(record[i] + 1);
                swap(arr, record, 0, record[i]);
                i++; // 加回去，下次遍历再来，走第二步，走if中的翻转
            }
        }
        return result;
    }

    /**
     * 翻转数组，实际翻转的还是arr数组，record记录的是位置发生的变化
     * 翻转数组核心思路是：一左一右定义两个指针，每次在record数组中
     * 更新这arr[left]和arr[right]这两个元素的位置，然后在arr数组中交换实际元素位置
     */
    private void swap(int[] arr, int[] record, int left, int right){
        while (left < right){
            record[arr[left]] = right;
            record[arr[right]] = left;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {3,2,4,1};
        System.out.println(solution.pancakeSort(arr));
    }

}
