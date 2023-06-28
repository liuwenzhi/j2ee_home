package lkhwtk.leetcode59;

/**
 * 59. 螺旋矩阵 II
 * 本题纯参考54题思路修改
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        //返回结果数组
        int[][] result = new int[n][n];
        int index = 1;
        int max = n*n;
        //定义左侧边界线left，右侧边界线right
        int left = 0, right = n-1;
        //定义上方边界线top，下方边界线down
        int top = 0, down = n-1;
        while (index<=max) {
            //第一步：从左向右遍历
            for (int i = left; i <= right; ++i) {
                //注意：这时候是横坐标不动纵坐标动
                result[top][i] = index++;
            }
            //从左向右扫描完元素之后，top自增，相当于上方边界线向下移动一层
            top++;
            //跳出条件，这里不包含等于
            if (top > down) break;
            //第二步：从上向下遍历
            for (int i = top; i <= down; ++i) {
                //注意：这时候是纵坐标不动横坐标动
                result[i][right] = index++;
            }
            //从上向下扫描完元素之后，right自减，相当于右侧边界线向左移动一层
            right--;
            if (left > right) break;
            //第三步：从右向左遍历
            for (int i = right; i >= left; --i) {
                //注意：这里是横坐标不动纵坐标动
                result[down][i] = index++;
            }
            //从右向左扫描完元素之后，down自减，相当于下方边界线向上移动一层
            down--;
            if (top > down) break;
            //第四步：从下向上遍历
            for (int i = down; i >= top; --i) {
                //注意：这里是纵坐标不动横坐标动
                result[i][left] = index++;
            }
            //从下往上扫描完元素之后，left自增，相当于左侧边界线向右移动一层
            left++;
            if (left > right) break;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.generateMatrix(3);
    }
}
