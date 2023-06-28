package lkhwtk.leetcode874;

import java.util.HashSet;

/**
 * 874. 模拟行走机器人
 * 本题其实不是很复杂，主要是技巧性强
 */
public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //状态位：0,1,2,3分别代表北、东、南、西方向，初始为正北方；
        int status = 0;
        //x轴方向数组四个方向分别代表北，东，南，西，因为-1向右转，每次转90°，所以这么来设计，status%4的值为1和3时横向移动
        int[] dir_x = {0, 1, 0, -1};
        //y轴方向数组四个方向分别代表北，东，南，西，-2向左转，每次转90°，相当于向右转270°，status%4的值为0和2时纵向移动
        int[] dir_y = {1, 0, -1, 0};
        int x = 0;
        int y = 0;

        int max_distance = 0;
        //判断障碍物：将障碍物的x和y坐标组合成一个字符串用set保存障碍物，查找的时候只要判断当前坐标组成的串是否在set里即可。
        HashSet<String> blockSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1){
                status += 1;
            }
            if (commands[i] == -2){
                status += 3;
            }
            if (commands[i] > 0){
                for (int j = 0; j < commands[i]; j++) {
                    //每次循环中x和y只会有一个移动
                    int next_x = x + dir_x[status % 4];
                    int next_y = y + dir_y[status % 4];
                    if (blockSet.contains(next_x + "," + next_y)){
                        //碰到阻碍的点，直接跳出循环，因为不会经过这个点，只会停留在前一个点上
                        break;
                    }else {
                        x = next_x;
                        y = next_y;
                        max_distance = Math.max(max_distance, x*x+y*y);
                    }
                }
            }
        }
        return max_distance;
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++) {
            System.out.println(i & 1);
        }
    }
}
