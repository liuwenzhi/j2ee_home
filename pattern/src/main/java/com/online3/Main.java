package com.online3;

/**
 * 视频三面原题：
 * 参考类似题目：leetcode54,leetcode59题，思路是这两道题返回过来
 */
public class Main {
    public int getNum(int x,int y){
        //定义右，下，左，上边界，这个序列遍历重复右下左上
        int right = 1;
        int down = 1;
        int left = 1;
        int up = 1;
        //flag1控制水平移动，true表示向右，为false表示向左移动
        boolean flag1 = true;
        //flag2控制垂直移动，true表示向上，为false表示向下
        boolean flag2 = false;
        int num = 1;
        int temp_x = 0;
        int temp_y = 0;
        while(temp_x!=x&&temp_y!=y){
            if(temp_x!=x&&flag1) {
                for(int i=0;i<right;i++){
                    num++;
                    temp_x++;
                }
                right += 2;
                flag1 = false;
            }
            if(temp_x!=x&&!flag1){
                for(int i=0;i<left;i++){
                    num++;
                    temp_x--;
                }
                left += 2;
                flag1 = true;
            }
            if(temp_y!=y&&!flag2){
                for(int i=0;i<down;i++){
                    num++;
                    temp_y--;
                }
                down += 2;
                flag2 = true;
            }
            if(temp_y!=y&&flag2){
                for(int i=0;i<up;i++){
                    num++;
                    temp_y++;
                }
                up += 2;
                flag2 = false;
            }
        }
        return num;
    }

    public static void main(String[] args){
        Main main = new Main();
        System.out.println(main.getNum(-4,0));
    }
}
