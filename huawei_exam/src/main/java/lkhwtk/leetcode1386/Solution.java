package lkhwtk.leetcode1386;

import java.util.HashMap;
import java.util.Map;

/**
 * 1386. 安排电影院座位
 * 参考题解：官方
 */
public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //注意java语言引入二进制数字的写法
        int left = 0b11110000;//left是预约了高4位 6 7 8 9排的情况
        int middle = 0b11000011;//middle是中间四位，4 5 6 7的情况
        int right = 0b00001111;//right是预约了低四位，2 3 4 5排的情况
        //占座集合，key是排号，值是具体预约二进制值（每一排列的编号），不算1号和10号位，没有意义，座位号2到9对应预约二进制值0到7位（共8位）
        Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] seat: reservedSeats) {
            //遍历预约位置列表，如果预约的位置属于每一行的2号（列）到9号（列），则记录下具体预约二进制值
            if (seat[1] >= 2 && seat[1] <= 9) {
                //根据排号获取原始的二进制值
                int origin = occupied.containsKey(seat[0]) ? occupied.get(seat[0]) : 0;
                //在原始二进制值上累加seat[1]号位置对应的二进制位，第n排第i列对应二进制i-2号位，让1左移这些位正好是一个8位
                //二进制数字第i-2号位为1，其它位为0，拿到这个值和原始origin做或操作，相当于在原始值上做了一次累加
                int value = origin | (1 << (seat[1] - 2));
                occupied.put(seat[0], value);
            }
        }
        //如果存在没有被预约的排（总行数-被预约的排数），则这一排可以最多安排给两个家庭
        int ans = (n - occupied.size()) * 2;
        //注意map集合的遍历方式
        for (Map.Entry <Integer, Integer> entry : occupied.entrySet()) {
            int bitmask = entry.getValue();
            //每一排2到9号位有预约的情况下，最多只能安排给一个家庭，通过left，middle和right的比对方式来确认
            if (((bitmask | left) == left) || ((bitmask | middle) == middle) || ((bitmask | right) == right)) {
                ++ans;
            }
        }
        return ans;
    }

}
