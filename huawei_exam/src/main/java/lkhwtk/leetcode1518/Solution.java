package lkhwtk.leetcode1518;

/**
 * 1518. 换酒问题
 * 本题和牛客网22题思路基本一致，注意不同点，hj22题是最多能换多少瓶，本题是一共能喝多少瓶，
 * hj22题可以向老板借一瓶，本题不行
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        //买到的瓶数
        int result = numBottles;
        //剩余的空瓶
        int temp = numBottles;
        while(temp >= numExchange){
            //当前temp能兑换的饮料，统计到result中
            int a = temp/numExchange;
            result+=a;
            //剩余的空瓶累加
            temp = a+temp%numExchange;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(15,4));
    }
}
