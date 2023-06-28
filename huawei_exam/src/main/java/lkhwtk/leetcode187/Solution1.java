package lkhwtk.leetcode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *参考题解：重复的DNA序列 官方
 */
public class Solution1 {
    /*int L = 10, n = s.length();
        HashSet<String> seen = new HashSet(), output = new HashSet();

        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
        String tmp = s.substring(start, start + L);
        if (seen.contains(tmp)) output.add(tmp);
        seen.add(tmp);
        }
        return new ArrayList<String>(output);*/
    public List<String> findRepeatedDnaSequences(String s) {
        //在这里把s.length()拿出来，不在for循环里边取，能节省时间
        int L = 10,N = s.length();
        //这样定义set集合比单独定义和set = hashSet的方式都能减少执行时间
        HashSet<String> set = new HashSet<>(),result = new HashSet<>();
        for(int i=0;i<N-L+1;i++){
            String tmp = s.substring(i,i+L);
            if(set.contains(tmp)){
                result.add(tmp);
            }
            set.add(tmp);
        }
        //注意不能再for循环逻辑判断中直接把结果放到List列表中，会有重复数据，解决方式是存set再转一下list
        return new ArrayList<String>(result);
    }

}


