package com.duomu.hj43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 *
 *
 * 本题含有多组数据。
 *
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出
 * 复制
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */

public class Main {
    /**
     * 测试用例增加之后，走迷宫的过程中可以上下左右四个方向上找出路，这里采用递归+回溯的方式寻找答案
     */
    public int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    /**
     * 路径缓存，本题使用Stack和ArrayList的搭配是一个非常巧妙的设计，stack是先进后出，主要是用于递归计算新加入的元素不行就换，
     * 但是使用这种方式：minPath = new ArrayList<>(path) 又能够保证minPath中的对象，是按照输入顺序输出的，具体见Test0说明
     */
    private Stack<int[]> path;
    /**
     * 最终最短路径结果
     */
    private ArrayList<int[]> minPath;
    /**
     * 入参元素矩阵
     */
    private int[][] matrix;
    /**
     * 二维数组中某个点是否被访问过的标记数组
     */
    private boolean[][] visited;

    public static void main(String[] args) throws Exception {
        Main main= new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = null;
        while ((str1 = br.readLine()) != null) {
            String[] arr = str1.split(" ");
            int rows = Integer.parseInt(arr[0]);
            int cols = Integer.parseInt(arr[1]);
            main.path = new Stack<>();
            main.minPath = null;
            //定义一个原始的矩阵
            main.matrix = new int[rows][cols];
            //定义一个访问标记矩阵
            main.visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                //将入参录入原始矩阵
                String[] str2 = br.readLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    main.matrix[i][j] = Integer.parseInt(str2[j]);
                }
            }
            //从（0,0）这个位置开始递归遍历入参矩阵
            main.dfs(0, 0);

            StringBuilder sb = new StringBuilder();
            for (int[] res : main.minPath) {
                sb.append('(').append(res[0]).append(',').append(res[1]).append(")\n");
            }
            System.out.print(sb);
        }
    }

    /**
     * 采用回溯的方式寻找最短路径
     */
    private void dfs(int i, int j) {
        //递归出口条件1：如果i和j越界，或者i和j被访问过，或者原始矩阵中i和j的位置是墙或者当前路径的长度大于最短路径长度
        if (i > matrix.length - 1 || i < 0 || j > matrix[0].length - 1 || j < 0 ||
                visited[i][j] || matrix[i][j] == 1 ||(minPath != null && path.size() >= minPath.size())) {
            return;
        }
        //递归出口条件2：如果i和j走到了右下角，同时经过递归出口条件1，最短路径是空的，或者当前路径比最短路径长度小（经过出口1的过滤等于都不会走到这里），添加一个最短路径
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            //此时i和j是一条路径上的最后两个点，所以不用标记visited，直接进栈，计算路径，然后出栈即可
            path.add(new int[]{i, j});
            minPath = new ArrayList<>(path);
            path.pop();
            return;
        }
        //将当前路径放到path中
        path.add(new int[]{i, j});
        visited[i][j] = true;
        //从ij位置上下左右四个方向找位置
        for (int[] direction : directions) {
            dfs(i + direction[0], j + direction[1]);
        }
        //将当前路径从path中再拿出来
        visited[i][j] = false;
        path.pop();
    }
}
