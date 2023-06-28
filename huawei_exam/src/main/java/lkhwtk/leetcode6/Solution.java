package lkhwtk.leetcode6;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 参考题解：Z 字形变换（清晰图解） 精选
 * 核心技术思路：List使用StringBuilder做泛型，numRows的每一行，都对应一个StringBuilder
 * 所有的StringBuilder通过List进行管理，最后通过List把StringBuilder中的内容进行输出
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        //创建list列表以StringBuilder作为泛型，列表大小为行数，列表中每个元素设置为一个StringBuilder对象
        List<StringBuilder> list = new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++){
            StringBuilder stringBuilder = new StringBuilder();
            list.add(stringBuilder);
        }
        //用flag的正反来控制向上或者向下遍历list列表中元素
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            list.get(i).append(c);
            if(i == 0 || i == numRows -1){
                flag = - flag;
            }
            i += flag;
        }
        //注意通过List列表中拿到StringBuilder，然后再把StringBuilder拼接成结果的方式
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : list) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCDEFGH",3));
    }
}
