package coder.NC18;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试将一个list列表中的n*n个元素转成二维整形数组
 */
public class Test {
    public int[][] rotateMatrix(int[][] mat, int n) {
        //返回结果列表
        List<Integer> arr = new ArrayList<>();
        //定义左侧边界线left，右侧边界线right
        int left = 0, right = n-1;
        //定义上方边界线top，下方边界线down
        int top = 0, down = n-1;

        while (true) {
            //第一步：从左向右遍历
            for (int i = left; i <= right; ++i) {
                arr.add(mat[top][i]);
            }
            //从左向右扫描完元素之后，top自增，相当于上方边界线向下移动一层
            top++;
            //跳出条件，这里不包含等于，按照算法设计，top=down的时候，还能够遍历一行中部分元素
            if (top > down) break;
            //第二步：从上向下遍历
            for (int i = top; i <= down; ++i) {
                arr.add(mat[i][right]);
            }
            //从上向下扫描完元素之后，right自减，相当于右侧边界线向左移动一层
            right--;
            if (left > right) break;
            //第三步：从右向左遍历
            for (int i = right; i >= left; --i) {
                arr.add(mat[down][i]);
            }
            //从右向左扫描完元素之后，down自减，相当于下方边界线向上移动一层
            down--;
            if (top > down) break;
            //第四步：从下向上遍历
            for (int i = down; i >= top; --i) {
                arr.add(mat[i][left]);
            }
            //从下往上扫描完元素之后，left自增，相当于左侧边界线向右移动一层
            left++;
            if (left > right) break;
        }
        //将结果列表转成维数组返回
        int[][] result = new int[n][n];
        int row = 0;
        for(int i=0;i<arr.size();i++){
            if(i>0&&i%n==0){
                row++;
            }
            result[row][i%n] = arr.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        Test solution1 = new Test();
        solution1.rotateMatrix(a,3);
        //System.out.println(1%10);
    }
}
