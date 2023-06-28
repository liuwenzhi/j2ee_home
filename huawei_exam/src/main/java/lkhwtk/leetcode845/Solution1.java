package lkhwtk.leetcode845;

/**
 * 参考hj24题思路进行改，hj24题和leetcode300等题目都是求递增子序列，本题是递增子数组，是连续的，这一点不同需要注意下。
 * 另外需要增加对没有山脉情况的排除，这个设计的时间效率已经比Solution提升了十几倍
 */
public class Solution1 {
    public int longestMountain(int[] arr) {
        int[] l = left(arr);
        int[] r = right(arr);
        //是否存在山脉的标记，即l和r数组中，至少有一个元素，对应的左侧递减序列和右侧递增序列同时大于1，没有山脉这个验证其实可以去掉，但是基本没有时间效率提升
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            if(l[i]!=1&&r[i]!=1){
                flag = true;
                break;
            }
        }
        //没有山脉的情况
        if(!flag){
            return 0;
        }
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            //在组成山脉的情况下进行判断，之前的if语句已经排除了完全没有山脉的情况
            if(l[i]!=1&&r[i]!=1) {
                //注意：因为左右侧最大子数组都包含了当前元素本身，所以左右累加的时候，需要去掉本身
                if (max < (l[i] + r[i] - 1)) {
                    max = l[i] + r[i] - 1;
                }
            }
        }
        return max;
    }

    /**
     * 获取数组中每个元素左侧递增序列元素数量（包括当前元素本身）
     * 基于动态规划方式
     */
    public int[] left(int[] arr){
        int[] dp = new int[arr.length];
        for(int i =0 ; i < arr.length; i++){
            //初始化个数为1，即当前元素本身
            dp[i] = 1;
            //注意这里的处理方式，和leetcode300题不同，这里是求连续子数组
            if(i>0&&arr[i]>arr[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
        return dp;
    }

    /**
     * 获取数组中每个元素右侧递减元素数量（包括当前元素本身）
     * 基于动态规划方式
     */
    public int[]  right(int[] arr){
        int[] dp= new int[arr.length];
        for(int i =arr.length-1 ; i >= 0; i--){
            //初始化个数为1，即当前元素本身
            dp[i] = 1;
            if(i<arr.length-1&&arr[i]>arr[i+1]){
                dp[i] = dp[i+1]+1;
            }
        }
        return dp;
    }

    public static void main(String[] args){
        int a[] = {2,3,1,2,3,4,5,6};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestMountain(a));
    }
}
