package lkhwtk.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 参考题解：视频题解：【动画模拟】一下就能搞懂，很简单
 * 注意：本题图示和实际代码有一点点区别，主要在于上下左右的边界，图示上为了更加清晰，把边界线画在元素矩形
 * 的外围边框上，实际代码实现逻辑中，边界线都是经过元素矩形区域，所以跳出条件中，只有大于没有等于，纯按照
 * 图示理解可能包括等于。本题算法非常巧妙。59题采用和本题同样思路。
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //返回结果列表
        List<Integer> arr = new ArrayList<>();
        //定义左侧边界线left，右侧边界线right
        int left = 0, right = matrix[0].length-1;
        //定义上方边界线top，下方边界线down
        int top = 0, down = matrix.length-1;

        while (true) {
            //第一步：从左向右遍历
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            //从左向右扫描完元素之后，top自增，相当于上方边界线向下移动一层
            top++;
            //跳出条件，这里不包含等于，按照算法设计，top=down的时候，还能够遍历一行中部分元素
            if (top > down) break;
            //第二步：从上向下遍历
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            //从上向下扫描完元素之后，right自减，相当于右侧边界线向左移动一层
            right--;
            if (left > right) break;
            //第三步：从右向左遍历
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            //从右向左扫描完元素之后，down自减，相当于下方边界线向上移动一层
            down--;
            if (top > down) break;
            //第四步：从下向上遍历
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            //从下往上扫描完元素之后，left自增，相当于左侧边界线向右移动一层
            left++;
            if (left > right) break;

        }
        return arr;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.spiralOrder(matrix);
    }
}
