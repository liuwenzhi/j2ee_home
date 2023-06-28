package lkhwtk.leetcode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. 重复的DNA序列
 * 可以类比下本题和牛客网63题，63题也是关于DNA序列的统计
 * 本人思路超时了，一共31个用例执行完30个，最后一个用例超时
 * 改进版本参考solution1，不用自己一遍一遍遍历字符串，通过集合框架来判断
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()-10+1;i++){
            String sub = s.substring(i,i+10);
            int copy = 0;
            for(int j=0;j<s.length()-10+1;j++){
                if(sub.equals(s.substring(j,j+10))){
                    copy++;
                }
            }
            if(copy>1){
                set.add(sub);
            }
        }
        List<String> result = new ArrayList<>(set.size());
        set.forEach(e->{
            result.add(e);
        });
        return result;
    }
}
