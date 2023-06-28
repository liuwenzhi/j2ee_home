package lkhwtk.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 参考题解：官方
 * 核心思路：递归+回溯
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        //最终返回组合结果集合
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        //注意map集合的初始化方式
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    /**
     * 递归回溯方法
     *
     * @param combinations 结果结合
     * @param phoneMap 号码字母对应表
     * @param digits 输入数字
     * @param index 组合了字母的个数，上限是digits.length-1,这个值到了digits.length就是递归方法的实际出口
     * @param combination 字母组合
     */
    private void backtrack(List<String> combinations,Map<Character, String> phoneMap,String digits, int index, StringBuilder combination){
        //递归方法出口，拼接字母到了上限长度
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            //每次取出digits不同位置的数字
            char c = digits.charAt(index);
            String letters = phoneMap.get(c);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                //最后一步删除非常重要，避免当前位置出现重复数据
                combination.deleteCharAt(index);
            }
        }
    }

}
