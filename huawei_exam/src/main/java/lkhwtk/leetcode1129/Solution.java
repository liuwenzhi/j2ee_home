package lkhwtk.leetcode1129;

import java.util.ArrayList;
import java.util.List;

/**
 * 1129. 颜色交替的最短路径
 * 参考题解：C++ 深度优先搜索
 * 颜色交替深度优先搜索，不断更新最短距离
 * 这里用了207、210那种初始化课程的方式初始化有向图边的关系集合
 */
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        //这是 红色线的集合
        List<List<Integer>> rg = new ArrayList<>();
        //这是 蓝色线的集合
        List<List<Integer>> bg = new ArrayList<>();

        //初始化红蓝两条线的集合，初始化为空列表
        for (int i = 0; i < n; i++) {
            rg.add(new ArrayList<>());
            bg.add(new ArrayList<>());
        }

        //根据red_edges，blue_edges初始化集合元素，外层列表的序号0...n-1正好代表了起始节点编号，内存list列表中的元素存放目的端节点
        for (int[] red : red_edges){
            rg.get(red[0]).add(red[1]);
        }
        for (int[] blue : blue_edges){
            bg.get(blue[0]).add(blue[1]);
        }

        //ans作为一个临时的n行2列元素，表达：从0节点，到各个节点（n行），先走红线的最短距离和先走蓝线的最短距离
        int[][] ans = new int[n][2];
        for (int[] ansColor : ans) {
            //初始化所有距离为MAX
            ansColor[0] = Integer.MAX_VALUE;
            ansColor[1] = Integer.MAX_VALUE;
        }
        //出发点距离设为0，0点到0点距离为0
        ans[0][0] = 0;
        ans[0][1] = 0;

        //从红色线出发，color：0
        dfs(ans, 0, 0, rg, bg);
        //从蓝色线出发，color：1
        dfs(ans, 1, 0, rg, bg);

        //最终返回最小路径结果数组，从之前红蓝二维数组中每一行找最小的元素
        int[] finalAns = new int[n];
        for (int i = 0; i < n; i++) {
            //取最小值  没有的话为-1
            finalAns[i] = Math.min(ans[i][0], ans[i][1]);
            //如果存在到达不了的点，返回-1
            if (finalAns[i] == Integer.MAX_VALUE)
                finalAns[i] = -1;
        }
        return finalAns;
    }

    /**
     * 深度优先遍历
     * @param color 0：红线，1：蓝线
     */
    public void dfs(int[][] ans, int color, int i, List<List<Integer>> rg, List<List<Integer>> bg) {
        //根据color入参选择红线集合或者蓝线集合
        List<List<Integer>> g = color == 0 ? rg : bg;
        //获取从起点i能够达到的节点的红线或者蓝线集合，一个一个遍历节点
        for (int j : g.get(i)) {
            //判断 0 -> i -> j 的长度（0->i :ans[i][color]，再到j就是ans[i][color]+1）是否 比 已有的 0 -> j 的路径长度短
            //若是 则更新，这里的比较，每次都是用不同颜色的路径进行比较
            if (ans[i][color] + 1 < ans[j][Math.abs(color - 1)]) {
                //!!!这个判断是整个算法的核心
                //当再也找不到更短的路径时 dfs会停止搜索 否则继续
                ans[j][Math.abs(color - 1)] = ans[i][color] + 1;
                //换一个颜色的线去遍历，color-1可能等于0,1和-1，加一个绝对值控制就实现了0和1的互换
                dfs(ans, Math.abs(color - 1), j, rg, bg);
            }
        }
    }

}
