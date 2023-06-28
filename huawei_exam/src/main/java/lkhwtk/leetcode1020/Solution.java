package lkhwtk.leetcode1020;

/**
 * 1020. 飞地的数量
 * 本题参考130题思路，从边界开始找1，
 */
public class Solution {
    public int numEnclaves(int[][] grid) {
        //判断是否是边界
        boolean isEdge;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                isEdge = false;
                //如果是边界的情况，isEdge
                if(i==0 || j==0 || i==grid.length-1 || j==grid[i].length-1){
                    isEdge = true;
                }
                //根据题意：从边界上找1，然后从这个点开始进行图的深度优先遍历，把能访问到的点都改为0，经过深度优先遍历改成0之后，数组中剩下的1的个数就是最终答案
                if(isEdge&&grid[i][j]==1){
                    dfs(grid,i,j);
                }
            }
        }
        //通过深度优先遍历之后，统计一下陆地数量
        int result = 0;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 通过深度优先遍历修改grid数组，把从0
     */
    private void dfs(int[][] grid,int i,int j){
        //先过滤掉超范围的数据，或者已经被标记为0的记录
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0){
            return ;
        }
        //把能从边界的1深度遍历到的1都设置为0，进行沉岛
        grid[i][j] = 0;
        //深度优先遍历(i,j)的上下左右几个元素，一个思考点：这里按照上下左右的顺序递归遍历最省时间，换了顺序不影响功能，但是更耗时
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
