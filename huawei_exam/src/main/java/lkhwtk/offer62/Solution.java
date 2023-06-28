package lkhwtk.offer62;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 参考题解：Java解决约瑟夫环问题，告诉你为什么模拟会超时！
 * 借助列表实现，耗时过多
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i);
        }
        //list列表中删除元素的位置
        int index = 0;
        while(n>1){
            index = (index+m-1)%n;
            System.out.println(index);
            //删除list列表中，index这个位置的元素
            list.remove(index);
            //删除元素之后列表长度一定要递减
            n--;
        }
        return list.get(0);
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.lastRemaining(5,3);
    }
}
