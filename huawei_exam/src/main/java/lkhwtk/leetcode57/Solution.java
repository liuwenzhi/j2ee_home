package lkhwtk.leetcode57;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 参考题解：「手画图解」57. 插入区间 | 分成 3 个阶段考察
 * 最多可以将intervals数组分成三个部分，左边不重合，中间重合，右边不重合部分
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int rows = intervals.length;
        //如果intervals长度为0的情况
        if(rows == 0){
            list.add(newInterval);
            //list<int[]>列表转二维数组，必须要在new int后边增加一个初始化参数，可以使0，可以使list.size()
            return list.toArray(new int[0][]);
        }
        int i = 0;
        //左边不重合部分，即intervals[i][1]右侧边界小于newInterval[0]，newInterval一维数组只有两个元素
        while (i < rows && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        //中间重合部分，此时在经历了第一个while循环之后，接下来如果intervals还有元素的话，那么一定有：intervals[i][1] >= newInterval[0]
        //即：题解中蓝区间的左端在绿区间里边，接下来就是找绿区间的开头，是否大于了蓝区间的结尾，小于等于的时候就是存在交集的情况，题解中这个设计非常巧
        while (i < rows && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        //newInterval元素值进行了改变
        list.add(newInterval);

        //右边不重合部分，最后一步intervals[i][0] > newInterval[1]这个条件可以去掉了，直接把右边剩余的元素加进来，
        while(i<rows&&intervals[i][0] > newInterval[1]){
            list.add(intervals[i]);
            i++;
        }
        //list<int[]>列表转二维数组，必须要在new int后边增加一个初始化参数，可以使0，可以使list.size()
        return list.toArray(new int[0][]);

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] a = {{1,3},{6,9}};
        int[] b = {2,5};
        int[][] result = solution.insert(a,b);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
