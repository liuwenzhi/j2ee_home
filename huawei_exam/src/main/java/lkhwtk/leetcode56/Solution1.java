package lkhwtk.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Solution方案的简单优化
 * 28行和34行代码干一件事情，优化下放到一块
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] currentInterval = intervals[i];
            //首个区间直接放到result结果中
            if(result.isEmpty()||result.size()==0||result.get(result.size()-1)[1]<currentInterval[0]){
                result.add(currentInterval);
            }else{
                //涉及合并，左边界已经经过排序了，直接确认右边界那个大的即可
                int[] lastestInterval = result.get(result.size()-1);
                lastestInterval[1] = Math.max(lastestInterval[1],currentInterval[1]);
            }
        }
        //注意将list列表转为二维数组的方式，也可以返回return result.toArray(new int[result.size()][2]);
        return result.toArray(new int[result.size()][]);
    }
}
