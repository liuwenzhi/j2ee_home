package lkhwtk.mst1619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.19. 水域大小
 * 个人思路：图的深度优先遍历
 */
public class Solution {
    public int[] pondSizes(int[][] land) {
        //2021年9月4日二轮刷题去掉，题目说明中已经明确land的长和宽都大于0
        /*if (land == null || land.length == 0) {
            return new int[]{0};
        }*/
        int rows = land.length;
        int cols = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (land[r][c] == 0) {
                    int result = dfs(land, r, c);
                    if(result>0){
                        list.add(result);
                    }
                }
            }
        }
        //拿到结果之后转成数组，再排个序
        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++){
            a[i] = list.get(i);
        }

        // 第二种List<Integer>转int[]，优雅，但是相对低效
        //int[] result = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(a);
        return a;
    }

    int dfs(int[][] land, int r, int c) {
        int result = 0;
        //获取二维数组行数
        int rows = land.length;
        //获取二维数组列数
        int cols = land[0].length;
        //行列超过边界，或者不是0就停止访问
        if (r < 0 || c < 0 || r >= rows || c >= cols || land[r][c] != 0) {
            return result;
        }
        //访问到数组中一个点，就将该值标记为3，已经访问过，按照本题算法，标记为除0之外的数字都可以
        land[r][c] = 3;
        //result增加1，这个自增非常重要，不然整个递归返回结果都是0
        result++;
        //深度遍历该节点的上下左右四个点
        result+=dfs(land, r - 1, c);
        result+=dfs(land, r + 1, c);
        result+=dfs(land, r, c - 1);
        result+=dfs(land, r, c + 1);
        //深度遍历该点的对角线四个点，左上，右下，左下，右上
        result+=dfs(land, r - 1, c-1);
        result+=dfs(land, r + 1, c+1);
        result+=dfs(land, r+1, c - 1);
        result+=dfs(land, r-1, c + 1);
        return result;
    }

    public static void main(String[] args){
        int[][] land = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        Solution solution = new Solution();
        solution.pondSizes(land);
    }
}
