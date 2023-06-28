package lkhwtk.leetcode323;

import java.util.ArrayList;
import java.util.List;

/**
 * 323. 无向图中连通分量的数目
 * 本题抄的207题，210题思路
 */
public class Solution {

    /**节点访问数组，0未连通，1连通，无向图中不怕有环，环的问题不用管，找到就是找到了*/
    private int[] visited;

    /**边集合列表*/
    private  List<List<Integer>> edgeList;

    public int countComponents(int n, int[][] edges) {
        int result = 0;
        if(n==0){
            return result;
        }
        //初始化访问数组元素为0，未访问
        visited = new int[n];
        //初始化边集合列表
        edgeList = new ArrayList<>();
        //初始化边集合，因为n为从0到n-1，所以可以直接根据list中元素的编号来确认key
        for (int i = 0; i < n; ++i) {
            edgeList.add(new ArrayList<>());
        }
        for (int[] info : edges) {
            edgeList.get(info[0]).add(info[1]);
            edgeList.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
                //深度优先遍历完成一次，结果增加1，找出来一条路径
                result++;
            }
        }
        return result;
    }

    /**
     * 深度优先遍历图，图有环没有问题
     */
    public void dfs(int u) {
        //该节点标记为连通，无向图不用管环的问题
        visited[u] = 1;
        for (int v: edgeList.get(u)) {
            //System.out.println("递归key:"+u+"，递归value："+v);
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
            }
            //注意：这里不能加else return，可能for循环没有执行完就退出了，同时无向图也不涉及环。
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(solution.countComponents(5,edges));
    }
}
