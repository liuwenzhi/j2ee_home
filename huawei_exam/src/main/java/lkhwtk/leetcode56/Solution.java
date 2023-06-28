package lkhwtk.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 解题参考：第二个视频
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        /*覆写下sort的排序比较器，比较二维数组中每一个一维数组元素的第一个元素值，按照这个来进行排序，
        比如[[2,4],[1,3]]，排序后[[1,3],[2,4]]，这样来排序之之后更容易处理集合*/
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 2. 初始化 result, 用于存储合并之后区间结果的动态数组
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] currentInterval = intervals[i];
            //首个区间直接放到result结果中
            if(result.isEmpty()||result.size()==0){
                result.add(currentInterval);
            }else{
                //获取result集合中最后一个元素，currentLastInterval[1]为该元素的右侧边界
                int[] lastestInterval = result.get(result.size()-1);
                //不涉及合并
                if(lastestInterval[1]<currentInterval[0]){
                    result.add(currentInterval);
                }else{
                    //涉及合并，左边界已经经过排序了，直接确认右边界那个大的即可
                    lastestInterval[1] = Math.max(lastestInterval[1],currentInterval[1]);
                }
            }
        }
        //注意将list列表转为二维数组的方式，也可以返回return result.toArray(new int[result.size()][2]);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        //细节知识点：二维数组初始化需要给定行的初始化大小
        int[][] a = new int[1][];
    }
}
