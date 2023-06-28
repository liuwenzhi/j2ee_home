package lkhwtk.offer29;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 本题和leetcode54题一致，不同点有两个
 * 1、这里需要单独判断下matrix的长度是否为0，并做一个单独处理
 * 2、leetcode54题最终返回一个list列表，本题返回一个整形数组，开始直接抄54题思路，最后将列表转成数组，
 * 转数组的过程中发现一点问题，可参考代码最后边的注释。结果先存列表后转数组，耗时4s，改成直接用数组存储
 * 之后耗时1s，时间效率从18.11%提升至97.4%
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int[] result = new int[matrix.length*matrix[0].length];
        int index = 0;
        //定义左侧边界线left，右侧边界线right
        int left = 0, right = matrix[0].length-1;
        //定义上方边界线top，下方边界线down
        int top = 0, down = matrix.length-1;

        while (true) {
            //第一步：从左向右遍历
            for (int i = left; i <= right; ++i) {
                result[index++] = matrix[top][i];
            }
            //从左向右扫描完元素之后，top自增，相当于上方边界线向下移动一层
            top++;
            //跳出条件，这里不包含等于
            if (top > down) break;
            //第二步：从上向下遍历
            for (int i = top; i <= down; ++i) {
                result[index++] = matrix[i][right];
            }
            //从上向下扫描完元素之后，right自减，相当于右侧边界线向左移动一层
            right--;
            if (left > right) break;
            //第三步：从右向左遍历
            for (int i = right; i >= left; --i) {
                result[index++] = matrix[down][i];
            }
            //从右向左扫描完元素之后，down自减，相当于下方边界线向上移动一层
            down--;
            if (top > down) break;
            //第四步：从下向上遍历
            for (int i = down; i >= top; --i) {
                result[index++] = matrix[i][left];
            }
            //从下往上扫描完元素之后，left自增，相当于左侧边界线向右移动一层
            left++;
            if (left > right) break;

        }
        //注意：toArray的方式能把list列表转成二维数组，转一维数组没有这个方法，单位jdk版本是11
        //todo 二轮刷这个题的时候，和面试题0807对比下，0807 List<String>直接能转一维数组，这个确认下是否和String本身是字符数组有关。
        //202110月3号记录：暂时确实没有发现能直接toArray转成int型一维数组，可以参考下1313题的方式：return list.stream().mapToInt(Integer::intValue).toArray();
        //arr.toArray(new int[arr.size()][]);
        return result;
    }
}
