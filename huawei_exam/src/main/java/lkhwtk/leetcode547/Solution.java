package lkhwtk.leetcode547;

/**
 * 547. 省份数量
 * 图的深度优先遍历实现方案
 * 重点考虑深度优先遍历和并查集
 */
public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        //城市是否被访问标记数组
        boolean[] visited = new boolean[provinces];
        //省份数量
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                //每次深度优先遍历一次isConnected数组，就把visited中对应位置标记为true
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    /**
     * @param isConnected 原始有向无环图二维矩阵
     * @param visited 城市访问标记
     * @param provinces 城市数量
     * @param i 当前城市编号（0到provinces-1），通过这个城市能够连通的城市进行标记
     */
    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }
    public static void main(String[] args){
        /*int[][] m = new int[3][4];
        System.out.println(m.length); 输出3*/
        Solution solution = new Solution();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        solution.findCircleNum(isConnected);
    }
}
