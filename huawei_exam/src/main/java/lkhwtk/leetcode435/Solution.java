package lkhwtk.leetcode435;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 435. 无重叠区间
 * 参考思路：罗志祥思路视频
 * 可以采用逆向思维：intervals中一共包括多少个不重复的区间，采用贪心算法，
 * 优先选择右边界小的区间（罗志祥模型，选择最早结束的时间，剩余最多的时间去干其他事情）
 * 本题和56题很相似，注意下二维数组排序方式。本题可以当做一个固定的递归算法来记一下。找最早结束的，留下最大的剩余空间。这样能保证省下的最多。
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //定义区间个数常量
        int length = intervals.length;
        if(length==0){
            return 0;
        }
        //对二维数组按照结束时间点进行排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //resultList存放区间不重复的区间集合
        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);

        //基于贪心算法的思路：优先选择早结束的时间点，基于罗志祥模型保证了后边有最大的剩余空间，第一项必选
        for(int i=1;i<length;i++){
            //下一个区间的开始比上一个区间的结束大或者相等
            if(intervals[i][0]>=resultList.get(resultList.size()-1)[1]){
                resultList.add(intervals[i]);
            }
        }
        return length - resultList.size();

    }

    public static void main(String[] args){
        int[][] intervals = {{1,2}, {2,3}, {3,1}, {1,3}};
        //按照二维数组第一个元素升序排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //按照二维数组第二个元素升序排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        System.out.println("aaaaaa");
    }
}
