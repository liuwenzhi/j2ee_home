package lkhwtk.leetcode134;

/**
 * 134. 加油站
 * 个人思路：两层for循环，直接按照个人思路即可。
 * cost[i]记录的是从i到i+1站消耗的汽油，本人直接从开始站开始，用加的油-耗的油，到下一站正好是路程上消耗的油
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        //外层for循环为选择的加油站起点
        for(int i=0;i<length;i++){
            //是否能环绕一周的标志
            boolean flag = true;
            //油量剩余
            int gasRemain = 0;
            //如果加油量没有油耗大，则肯定不能找这个起点
            if(gas[i]<cost[i]){
                continue;
            }
            int j = i;
            while(j<length+i+1){
                //环绕一周采用j从i开始，自增，每次+length然后和length取余的方式
                int index = (j+length)%length;
                gasRemain += gas[index]-cost[index];
                //油量不足直接跳出内层循环
                if(gasRemain<0){
                    flag = false;
                    break;
                }
                j++;
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas,cost));
    }
}
