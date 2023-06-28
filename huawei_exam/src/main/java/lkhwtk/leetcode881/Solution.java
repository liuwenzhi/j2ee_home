package lkhwtk.leetcode881;

import java.util.Arrays;

/**
 * 结题参考：救生艇 官方
 * 核心思路：贪心+双指针，把最重的和最轻的人一起放到一艘船上。贪心的思路是：要让承载两个人的船尽可能的多，
 * 如果最重的人不能和最轻的人同载一艘船，那么最重的人只能独自乘坐一艘船。如果体重轻的人能和体重最重的人乘坐一艘船，
 * 那么他一定能和其他人乘坐一艘船，分配到最重的乘坐一艘船最合适。
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //排序数组，体重轻的在前边，大号的在后边
        Arrays.sort(people);
        int boats = 0;
        int i = 0,j=people.length-1;
        //注意：这里包含了i==j的情况，可能会剩下最后中间那一个人，直接让船数加1，后边的判断和左右指针移动不影响
        while(i<=j){
            //每次循环都有一个人上船
            boats++;
            //如果后边大号的不能和前边体重轻的人乘坐一艘船，那么只能大号的自己上一艘
            if(people[i]+people[j]<=limit){
                //如果后边大号的能和前边体重轻的人乘坐一艘船，那么前边人也上船，左指针i往后走
                i++;
            }
            //每次循环保证大号的能上一艘船，右指针j往前走
            j--;
        }
        return boats;
    }
}
