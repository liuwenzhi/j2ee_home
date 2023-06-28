package moni;

/**
 * 给定⼀个正数数组arr（即数组元素全是正数），找出该数组中，两个元素相减的最⼤值，其中被减数的下标不⼩于减数的下标。
 * 即求出： maxValue = max{arr[j]-arr[i] and j >= i} （java）
 */
public class Test4 {
    //核心思路：滑动窗口
    public static void main(String[] args){
        int[] a = {1,2,3,4,7,8,9,22,21,13,5,6};
        //找到窗口中的最大值和最小值
        int max = Math.max(a[0],a[1]);
        int min = Math.min(a[0],a[1]);
        int result = a[1]-a[0];
        for(int i=2;i<a.length;i++){
            //每次向后找到的元素比max大，则更新max，更新result
            if(a[i]>max){
                max = a[i];
                result = a[i] - min;
            }else if(a[i]<min){
                //每次向后找到的元素比min小，则更新min，因为被减数的下标不小于减数下标，所以不能计算result
                min = a[i];
            }
        }
        System.out.println(result);
    }
}
