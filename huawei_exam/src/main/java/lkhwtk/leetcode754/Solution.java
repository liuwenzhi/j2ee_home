package lkhwtk.leetcode754;

/**
 * 754. 到达终点数字
 * 参考题解：等价于数组添加正负号问题
 */
public class Solution {
    public int reachNumber(int target) {
        //数轴关于原点对称，左右边怎么走，数字确认之后改了方向就好了，只需要考虑数轴右边x>0的情况
        if(target<0){
            target = -target;
        }
        int i = 1;
        while(true){
            //i个数的总和s
            int s = i*(i+1)/2;
            //累加和大于等于target并且奇偶性相同，这个条件很不好想出来，如果s=1，target=3就不行，此时s比target小，不满足题目中假设条件
            if(s>=target&&((s - target) % 2 == 0)){
                return i;
            }
            i++;
        }

    }
}
