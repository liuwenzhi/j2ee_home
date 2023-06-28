package lkhwtk.leetcode923;

import java.util.Arrays;

/**
 * 923. 三数之和的多种可能
 * 参考题解：官方，三指针思路，核心思路：类似于计算三数之和（leetcode 15题），定下一个数，用两个指针找另外两个数。
 * 然后单独处理下两个指针处元素重复情况，以及两个指针元素相等的情况，注意本题坑点：java整形最大数字
 * 2147483647，十进制情况下长度为10位，然后在统计的过程中可能会出现中间结果超过这个值的范围，需要将
 * 返回结果求定义成long型对MOD求模，最终再把long转成int。
 */
public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        //注意：大整数可以加下划线这么写，验证方式参考main方法
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i) {
            //固定arr[i]，设计两个指针j=i+1,k=arr.length-1，设T=target - arr[i]，
            //固定好arr[i]之后从头和尾找arr[j] + arr[k] == T，注意：这种双指针一头一尾查找的方式需要先将数组排序好。
            int T = target - arr[i];
            int j = i+1, k = arr.length - 1;

            while (j < k) {
                //和比T小j往后走
                if (arr[j] + arr[k] < T) {
                    j++;
                } else if (arr[j] + arr[k] > T) {
                    //和比T大k往前走
                    k--;
                }else if (arr[j] != arr[k]) {
                    //arr[j] + arr[k] == T的情况下，首尾两个指针不相等的情况，但是可能有arr[j]==arr[j+1]==arr[j+2]...这种情况
                    int left = 1, right = 1;
                    while (j+1 < k && arr[j] == arr[j+1]) {
                        //统计左边重复元素个数，注意：此时的大前提是两个边界值不相等：arr[j] != arr[k]，不用考虑过界情况
                        left++;
                        j++;
                    }
                    while (k-1 > j && arr[k] == arr[k-1]) {
                        //统计右边重复元素个数，注意：此时的大前提是两个边界值不相等：arr[j] != arr[k]，不用考虑过界情况
                        right++;
                        k--;
                    }
                    //左边个数*右边个数就是此时满足条件的元组数
                    ans += left * right;
                    //这个值可能非常大，需要在这里进行一次取模
                    ans %= MOD;
                    //类似于15题，最后还需要j和k移动一次，保证新的位置上元素的值和之前不相等了
                    j++;
                    k--;
                } else {
                    //如果arr[j] + arr[k] == T 并且首尾两个元素相等，那么就有：j和k之间的元素个数为k - j + 1，这些元素都相等（提前已经排好序了）
                    //从这些个元素中任意取出两个都可以，任意取出两个的个数为((k-j+1) * (k-j)) /(2*1)，就是概率求组合的C n 2
                    ans += (k-j+1) * (k-j) / 2;
                    //结果可能非常大，取个模
                    ans %= MOD;
                    //如果首位元素相等了，循环到此结束，统计结束
                    break;
                }
            }
        }
        //ans在算法循环过程中使用long型，计算过程中可能非常大，不断进行取模，最后的十进制结果肯定能在10位数以内，直接转成整形
        return (int) ans;
    }

    public static void main(String[] args){
        //注意：数字太长，可以使用这种下划线的连接方式
        int a = 1_000_000_000;
        System.out.println(a);
        int b = 1000000000;
        System.out.println(b);
    }
}
