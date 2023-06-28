package lkhwtk.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 本题和646题属于一种思路，贪心算法去求解二维数组问题，也是按照[1]进行排序
 * 参考题解：「图解」谈谈我为什么按右端升序排序 | 452.用最少数量的箭引爆气球
 * 核心思路：
 * 1、拿当前区间的右端作为标杆。
 * 2、只要 下一个区间的左端<=标杆，则重合，继续寻求与下一个区间重合。
 * 3、直到遇到不重合的区间，弓箭数 +1。
 * 4、拿新区间的右端作为标杆，重复以上步骤。
 *
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        //按照v1进行升序排序，使用兰木达表达式方式对数组进行排序，效率能高很多，排序也可以a[1]>=b[1]return1，
        //不用最后return 0，但是空间复杂度会略有增加，可能是增加了一次移动
        Arrays.sort(points, (a, b) -> {
            if(a[1] > b[1]){
                return 1;
            }else if(a[1] < b[1]){
                return-1;
            }else{
                return 0;
            }
        });
        /*Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });*/

        //箭的数量
        int arrows = 0;
        int i = 0;
        while (i < points.length) {
            int right = points[i][1];
            i++;
            //查看多少个气球区间和当前气球区间有交集
            while (i < points.length && points[i][0] <= right) {
                i++;
            }
            arrows++;
        }
        return arrows;
    }

    public static void main(String[] args){
        //本题发现一个坑：在使用Arrays进行元素排序的时候，使用a-b的方式，下边这种情况无效
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        //整形的表示范围：-2147483648~2147483647
        //System.out.println(Integer.MAX_VALUE);
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        //int[][] points = {{2,3},{-2,-4}};
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
        System.out.println(2147483646<=-2147483645);
    }
}
