package lkhwtk.leetcode957;

import java.util.HashMap;
import java.util.Map;

/**
 * 957. N 天后的牢房
 * 直接算会超时，N可取到 1000000000
 */
public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        //周期14进行循环，这个是根据测试得出来的结果
        if(n>=14){
            n = n%14;
            if(n==0){
                n=14;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<7;j++){
                if(cells[j-1]==1&&cells[j+1]==1||cells[j-1]==0&&cells[j+1]==0){
                    map.put(j,1);
                }else{
                    map.put(j,0);
                }
            }
            //在第一天调整完其他元素之后，把首尾元素设置为0，这两个位置肯定不满足置为1的条件，从第二天开始就不再处理首尾元素
            if(i==0){
                map.put(0,0);
                map.put(7,0);
            }
            for(int j=0;j<8;j++){
                cells[j] = map.get(j);
            }
        }
        return cells;
    }

    public static void main(String[] args){
        System.out.println(1000000000/256);
        System.out.println(1000000000%256);

    }
}
