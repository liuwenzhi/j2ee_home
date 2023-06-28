package lkhwtk.leetcode525;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 参考题解：动图演示 -- 前缀和思想
 * 题解中思路梳理非常清晰，重点看下需要单独插入一个{0,-1}，保证结果是前几位的情况下能正常给出
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        //map的key存放当前累加的值，value存放具体位置
        HashMap<Integer,Integer> map = new HashMap<>();
        //单独插入一个0，-1，在数组的第0位之前有一个位置-1，-1这个位置上累加值是0，正常是遇到0减去1，遇到1增加1，插入（0，-1）
        //主要是基于算法配合保证序列开头在开始位置的情况下，得到正确的结果，比如序列0,1，先遇到0，cur--,map中存一个-1,0，到1这个位置，
        //cur增加后变成0了，1-（-1）得到距离是2，这个时候0不会继续存储到map了，就是-1这个位置，后边再有cur=0的情况，都是和-1这个位置比较
        map.put(0,-1);
        int cur = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                cur--;
            }else{
                cur++;
            }
            //map中有cur值就比对，看看从上个位置到这个位置距离多大，由于不包括上个地址，所以直接i-上个地址即可，没有+1
            if(map.containsKey(cur)){
                max = Math.max(max,i-map.get(cur));
            }else{
                //map中没有就存值，map中只会存储不同的值作为key，而且各个不同的值k都是保证i最小的
                map.put(cur,i);
            }
        }
        return max;
    }
}
