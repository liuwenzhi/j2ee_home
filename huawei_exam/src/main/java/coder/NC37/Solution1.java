package coder.NC37;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 基于leetcode56 题思路，用单层for循环，也没有实际提升效率
 * 通过本题和56题的比对可以发现：Collections.sort方法针对于list集合，Arrays.sort针对于数组
 */
public class Solution1 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        Collections.sort(intervals,(a, b)->a.start-b.start);
        for(Interval interval:intervals){
            //首个区间直接放到result结果中
            if(result.isEmpty()||result.size()==0){
                result.add(interval);
            }else{
                //获取result集合中最后一个元素
                Interval lastestInterval = result.get(result.size()-1);
                //不涉及合并
                if(lastestInterval.end<interval.start){
                    result.add(interval);
                }else{
                    //涉及合并，左边界已经经过排序了，直接确认右边界那个大的即可
                    lastestInterval.end = Math.max(lastestInterval.end,interval.end);
                }
            }
        }
        return result;
    }
}
