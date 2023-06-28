package lkhwtk.leetcode1177;

import java.util.ArrayList;
import java.util.List;

/**
 * 1177. 构建回文串检测
 * 参考题解：2进制表示字母数量奇偶性，重点看下题解下边的讨论
 * 注意判断回文数的点：出现偶数次的元素不用考虑，判断出现奇数次的元素个数/2，是否比k小，小的话可以通过替换方式使其变成回文数
 * 注意题目中标黑的字体：子串可以重新排列，基于这个想法确认出现偶数次的字符不考虑
 */
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int cur = 0;
        //state用于记录每一个s字串的字符状态
        int[] states = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            // (s.charAt(i) - 'a') 表示的是当前位置的字符与‘a' 字符的差值
            // 1 << (s.charAt(i) - 'a') 将1左移 差值大小位，
            // 可看成将这个字符表示成一个仅有一位是1的位向量，这个位向量对每一个字符是唯一的。
            // 比如 a 就是 00...001 , b 就是00...010, ...每一个字符对应32位。
            // 这种位向量的表示方式是人为设计的，也可以使用其他的表示方式，重点是要保证唯一，且只有一位是1。
            // 与cur异或，可认为是去除重复的字符，添加尚未存在的字符。
            // 比如 之前是a,现在又来了一个a，则 00...001 ^ 00...001，结果就会变成0，就不含a字符了。
            // 若之前是a,现在来了b,则00...001 ^ 00...010, 结果就变成了00...011,表示含有了a、b字符
            // 得到的cur表示的就是在当前位置之前，削掉所有出现了偶数次的字符后，所余下的字符对应的位向量。
            // 比如，余下了a,c,d,则此时cur就是 00...001101
            cur ^= (1 << (s.charAt(i) - 'a'));
            states[i] = cur;  //记录当前位置的状态，每遍历到一个字符，就增加一个状态位，state相当于s从低到高的子串的奇数个字符情况状态值
        }
        //循环结束后，我们就得到了在字符串每一个字符之前，包含本身，共出现了奇数次的字符的情况
        //那么，就可以根据开始位置字符的状态（0位置）或者开始位置前一个字符的状态（0位之后的位置）和结束位置状态做抑或操作，就可以得到这个区间内出现了奇数次的字符情况
        for (int i = 0; i < queries.length; i++) {
            // 若是从零开始，则取零；否则，取当前起始值的前一个的状态。
            // 因为我们上面得到的状态信息包含了自身，所以往前取一个才能将这一个字符算入
            int ostate = queries[i][0] > 0 ? states[queries[i][0] - 1] : 0;
            // 首尾异或，就得到了在这个区间内，出现了奇数次的字符的情况。
            // 因为，对任意字符，只有它仅出现在首向量或者尾向量中，才说明他必然在这个区间中。这一点很不好想
            int state = ostate ^ states[queries[i][1]];
            int cnt = 0;
            // 下面就是计数，直观上讲就是计算在state这个位向量中，1出现的次数。
            // 比如0001000100001001，则计数就是4
            /*while (state != 0) {
                if ((state & 1) == 1) cnt++;    // 最后一位是1，才计数
                state >>= 1;   // 右移一位
            }*/
            //上方注释代码是原有计数代码，位移很慢，下边这种方式效果更好，或者直接：cnt= Integer.bitCount(val)
            //另外注意：此时拿到的state是十进制数字，直接转字符串进行计算就错大了，统计1按按照位运算来，上边bitCount可以统计十进制数字的二进制1个数
            while(state != 0) {
                cnt++;
                state= state & (state - 1);
            }
            //这里统计完奇数个数cnt之后，用cnt/2来进行判断，重点是这么一种考虑：比如abcd这种情况，
            //可以替换a为c，b为d来得到回文字符串，或者abcde这种情况，可以把a替换e，b替换d，也能做成一个回文字符串，
            //如果奇数位只有1个，比如aaaac，k=1的情况，0小于等于1，满足条件，还有一种比较极端一点的情况：aacaa，k=0，这时候奇数位也是1，1/2==0,k=0是满足小于等于条件
            result.add(cnt / 2 <= queries[i][2]);
        }
        return result;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] queries = {{0,5,1}};
        System.out.println(solution.canMakePaliQueries("aacaad",queries));
    }
}
