package lkhwtk.leetcode1239;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * 参考题解：官方
 * 回溯+位运算
 */
public class Solution {
    private int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        //for循环是第一步，用位计算的方式，来判断每一个arr入参列表中的元素，是否有重复的字母，如果有，直接排除在外
        for (String s : arr) {
            //mask是这样的一个东西，将它看做一个二进制数字，第i位为1表示它第i位存在对应的小写字母，第i位是0表示它第i位不存在对应的小写字母
            //比如mask值是3，转成二进制数字是11，代表此时最终结果字符串包含的字母是ba，因为此题不管字符顺序问题，只求最大长度，所以可以这么搞
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                //若mask 已有 ch，则说明 s 含有重复字母，无法构成可行解， mask右移：s.charAt(i) - 'a'这个值
                //正好把要校验的这一位，移动到了右边第一位，比如s.charAt(i)是b，此时正好右移1位，mask这个值和
                //000...01进行按位与计算，如果值为1则说明mask中已经包含了b
                if (((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                //将ch加入mask中，实际是置mask对应位置的小写字母值为1，比如s.charAt(i)是b，ch此时是b-a=1，
                //将ch左移一位是10，因为之前已经判断了mask中没有b，所以再做一个或运算就是把mask中b这个位置标记为1
                //再比如s.charAt(i)是c，ch此时是c-a=2,左移一位是100，做或运算之后，让c这一位的值标记为1
                mask |= 1 << ch;
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }
        //在获取到单个词组没有重复字母的词组列表之后，执行递归，开始位置是0，初始比对mask也是0
        backtrack(masks, 0, 0);
        return ans;
    }

    /**
     * 第一步拿到不含有重复字母的词汇列表之后，判断这个列表中的元素是否能拼接，
     * 判断能否拼接的过程直接采用与计算，如果结果为0，就代表不含有重复元素，mask中
     * 每一个字母对应的位置都是固定的，所以可以直接通过位移计算进行判断
     */
    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            //通过bitCount统计mask转成二进制数字时，1的个数
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        //如果mask和masks.get(pos)不包含重复元素，则做一个或操作，进入下一轮递归
        if ((mask & masks.get(pos)) == 0) {
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        //注意：这里不是else，可以不选择当前pos位置元素进行一次递归，初始mask从0开始，
        //实际是进行了包含当前元素和不包含当前元素进行了两次递归
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args){
        List<String> arr = new ArrayList<>();
        arr.add("st");
        arr.add("str");
        Solution solution = new Solution();
        System.out.println(solution.maxLength(arr));
    }

}
