package coder.NC91;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * NC91 最长上升子序列(三)
 * 本题同leetcode300，多了拿出具体序列，按字典排序返回结果
 * 算法超时了
 */
public class Solution {
    public int[] LIS (int[] arr) {
        //dp[i]代表到第i个元素(以第i个元素结尾)，递增子序列的大小
        int[] dp = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++){
            //初始化为1，初始化非常重要，进行状态转移，初始化保证了多次转移的正确性
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                //如果发现前边有小的元素，就基于那个dp值累加1
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        //初始化一个max为1，然后遍历dp数组得到一个最大的距离值
        int max = 1;
        for(int i = 0; i < arr.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        //借助一个List<int[]>泛型把满足条件的结果拿出来
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(dp[i]==max){
                int[] cache = new int[max];
                int len = max;
                cache[--len] = arr[i];
                //从指定位置往前找，只要是比cache[len]小，就加到cache数组中，每一次比较后len都在递减
                for(int j=i-1;j>=0;j--){
                    if(arr[j]<cache[len]){
                        cache[--len] = arr[j];
                    }
                }
                result.add(cache);
            }
        }
        //自定义字典排序，基于字符串的方式最方便
        Collections.sort(result,new Comparator<int[]>() {
            public int compare(int[] a,int[] b) {
                String s1 = "";
                String s2 = "";
                for(int i=0;i<a.length;i++){
                    s1+=a[i];
                    s2+=b[i];
                }
                return (s1).compareTo(s2);
            }
        });
        return result.get(0);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {1,2,8,6,4};
        int[] result = solution.LIS(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
