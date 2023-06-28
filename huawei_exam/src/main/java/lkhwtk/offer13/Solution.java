package lkhwtk.offer13;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 图的深度优先遍历,本题二轮复习和200题等一起看下，属于一个思路
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        //通过深度优先遍历，将机器人能到达的点都标记为1
        dfs(grid,0,0,m,n,k);
        int result = 0;
        //通过深度优先遍历标记完数组之后，统计1的个数即机器人能到达的格子数
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int r, int c,int m, int n, int k) {
        //递归方法出口，访问的坐标超过边界，或者已经被访问过
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 1) {
            return;
        }
        //递归方法出口2，如果访问的行列信息各个位的和>k，则返回
        int sum = getBitSum(r,c);
        if(sum>k){
            return;
        }
        //访问到数组中一个点，就将该值标记为1，已经访问过
        grid[r][c] = 1;
        //深度遍历该节点的上下左右四个点
        dfs(grid, r - 1, c,m,n,k);
        dfs(grid, r + 1, c,m,n,k);
        dfs(grid, r, c - 1,m,n,k);
        dfs(grid, r, c + 1,m,n,k);
    }

    /**
     * 计算横纵坐标位数和
     */
    private int getBitSum(int r,int c){
        int sum = 0;
        //注意：这里不要漏掉10，条件一定是>=10
        while(r>=10){
            sum+=r%10;
            r = r/10;
        }
        sum+=r;
        while(c>=10){
            sum+=c%10;
            c=c/10;
        }
        sum+=c;
        return sum;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getBitSum(38,35));
        System.out.println(solution.movingCount(11,8,16));
    }

}
