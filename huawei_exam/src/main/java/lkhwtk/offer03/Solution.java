package lkhwtk.offer03;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * leetcode141题判断链表是否有重复，leetcode287题题解中都用到了本题的验证方式，判断set集合添加元素是否成功
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for(int num:nums){
            //直接判断是否添加成功，set集合中有重复的元素则会添加失败
            if(!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
