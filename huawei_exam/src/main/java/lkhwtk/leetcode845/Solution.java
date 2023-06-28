package lkhwtk.leetcode845;

/**
 * 845. 数组中的最长山脉
 * 个人思路
 */
public class Solution {
    public int longestMountain(int[] arr) {
        //数组长度达不到3，肯定不行
        if(arr.length<3){
            return 0;
        }
        int max = 0;
        for(int i=1;i<arr.length-1;i++){
            int left = i;
            int right = i;
            int temp = arr[i];
            //找左侧小的
            while(left>0){
                //注意：本题比较绕，这里一定是先预判，预判之后left再做自减操作
                if(arr[left-1] < temp){
                    temp = arr[left-1];
                    left--;
                }else if(arr[left-1] >= temp){
                    break;
                }
            }
            //如果左侧没有满足条件的递减序列，结束此次for循环，不统计结果
            if(left==i){
                continue;
            }
            //找右侧大的，需要重置temp
            temp = arr[i];
            while(right<arr.length-1){
                //注意：一定是先做预判，预判之后，right再做自增操作
                if(arr[right+1] < temp){
                    temp = arr[right+1];
                    right++;
                }else if(arr[right+1] >= temp){
                    break;
                }
            }
            //如果右侧没有满足条件的递增序列，结束此次for循环，不统计结果
            if(right==i){
                continue;
            }
            //比较山脉长度和max并在需要的时候替换max
            max = Math.max(max,right-left+1);
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
        //int[] arr = {2,2,2};
        System.out.println(solution.longestMountain(arr));
    }
}
