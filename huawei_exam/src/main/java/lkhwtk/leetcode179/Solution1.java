package lkhwtk.leetcode179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 本题基于字典排序只能跑完10%+的用例，需要用Solution思路做
 */
public class Solution1 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        //将原始整形数组转成字符串数组
        for(int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list,new Comparator<String>() {
            public int compare(String s1,String s2) {
                //从大到小排序，一定要设置后边和前边比较
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        Collections.sort(list);
        StringBuilder res = new StringBuilder();
        for(String s : list) {
            res.append(s);
        }
        String result = res.toString();
        //单独处理下以0开头的情况，00,000,0000，因为本题是求解最大数，所以只可能有这几种情况，不会出现0123这种
        //2021年8月30日二轮刷题，优化掉if条件中：&&result.length()>1，没有意义
        if(result.startsWith("0")){
            return "0";
        }
        return result;
    }
}
