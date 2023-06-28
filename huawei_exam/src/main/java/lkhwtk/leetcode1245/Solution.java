package lkhwtk.leetcode1245;

import java.util.ArrayList;
import java.util.List;

/**
 * 1245. 树的直径
 * 参考题解：树的DFS
 * 本题又是涉及到一个数学结论，先按照这个思路整理下
 * 核心思路：以任意一点为root，与其关联的点为子节点，求出所有子节点对应的路径的前两大值max1,max2，则该点对应的最长路径为max1+max2
 */
public class Solution {
    //最终结果
    int res = 0;
    public int treeDiameter(int[][] edges) {
        //定义一个列表数组，数组中每一个元素都是一个List列表，算法中通过这种设计维护一个类似邻接表的数据结构
        //数组中每一个编号对应树中节点的起点，存储的List列表存放从这个点能到达的点，注意这里是无向图，还有一个
        //核心的点：初始化为edges.length+1，一个连通的树的节点数等于边数+1，可以参考题目中的信息，这个细节一定要注意到
        List<Integer>[] map = new ArrayList[edges.length+1];
        //初始化map数组，每一个对象初始化为一个List列表
        for(int i=0 ; i<map.length ; i++){
            map[i] = new ArrayList<>();
        }
        //给map数组中每一个key（数组下标）中存储的list列表里加入节点，因为是无向图，所以来回加一下
        for(int[] edge : edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        dfs(map,0,new boolean[edges.length+1]);
        return res;
    }

    /**
     * 递归执行实现深度优先遍历，找到一个节点关联的字节点中最大的两个路径，再加上当前节点
     * 用一个简单例子理解下本题：{{0,1},{0,2}}，遍历节点1返回1,（递归过程中：max1=0，最后返回了max1+1，res=0），
     * 遍历节点2返回1，（max1=0，最后返回了max1+1,res=0），递归流程最后回到0的时候，res = max(0,1+1)=2
     */
    public int dfs(List<Integer>[] map,int index,boolean[] visited){
        //标记访问节点为true
        visited[index] = true;
        List<Integer> list = map[index];
        //max1是最大值，max2是第二大值
        int max1 = 0;
        int max2 = 0;
        for(int next : list){
            if(!visited[next]){
                int num = dfs(map,next,visited);
                if(num>max1){
                    //如果num比max1大，那么max1值赋给max2，num值赋给max1
                    max2 = max1;
                    max1 = num;
                } else if(num>max2){
                    //如果num比max1小，但是比max2大，那就直接替换max2
                    max2 = num;
                }
            }
        }
        //找到index节点的最大值直径：max1+max2
        res = Math.max(res,max1+max2);
        //该节点关联的全部子节点最大路径前两值的最大值，再加上当前节点值组成路径，实际按照算法，max1比max2要大，这里直接返回max1+1即可
        return max1+1;
        //return Math.max(max1,max2)+1;
    }

    /**
     * 验证下模拟临接表结构
     */
    public static void main(String[] args){
        //int[][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5}};
        int[][] edges = {{0,1},{0,2}};
        Solution solution = new Solution();
        System.out.println(solution.treeDiameter(edges));
        List<Integer>[] map = new ArrayList[edges.length+1];

        for(int i=0 ; i<map.length ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        System.out.println("Hello world");
    }

}
