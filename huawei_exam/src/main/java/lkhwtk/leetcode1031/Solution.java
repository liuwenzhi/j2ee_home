package lkhwtk.leetcode1031;

/**
 * 1031. 两个非重叠子数组的最大和
 * 思路很绕，参考注释理解会非常清晰
 */
public class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        //求一个前缀和
        for (int i = 1; i < A.length; ++i){
            A[i] += A[i - 1];
        }
        //初始化最终最大值的初始值，初始化L子数组和最大值，初始值化M子数组和最大值
        //初始化后，是前缀和数组中满足当前子数组长度下最靠左边的几个元素值
        int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
        for (int i = L + M; i < A.length; ++i) {
            //从前往后遍历数组，找长度为L的子数组最大和，此时是模拟L数组在M数组左边，A[i-L-M]是从0位置往后的元素，
            //for循环初始值i=L+M，max中算式为A[L]-A[0]，根据前缀和的计算，此时是不包括原始数组中A[0]的，初始化Lmax的时候A[L-1]包括
            Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
            //从前往后遍历数组，找长度为M的子数组最大和，此时是模拟M数组在L数组左边，A[i-L-M]是从0位置往后的元素
            //for循环初始值i=L+M，max中算式为A[M]-A[0]，根据前缀和的计算，此时是不包括原始数组中A[0]的，初始化Mmax的时候A[M-1]包括
            Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
            //比较L在左边的最大值+每次循环中当前位置i往前的一个M长度子数组和，M在左边并取最大值+每次循环中当前位置i往前的一个L长度子数组和
            //注意第二层max中的元素关系，和上边比对，计算Lmax时用：A[i - M] - A[i - L - M]，计算后边一个M长度子数组和用A[i] - A[i - M]，A[i] - A[i - M]实际不包括
            //原始数组中A[i-M]这个位置的元素，包括i这个位置的元素，计算Lmax时用：A[i - M] - A[i - L - M]，其实也是不包括开始位置的元素，但是注意：之前Lmax已经被初
            // 始化过了为A[L-1]，所以后边直接从L开始计算即可
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
        }
        return res;
    }
    public static void main(String[] args){
        int[] a = {0,6,5,2,2,5,1,9,4};
        Solution solution = new Solution();
        System.out.println(solution.maxSumTwoNoOverlap(a,1,2));
    }
}
