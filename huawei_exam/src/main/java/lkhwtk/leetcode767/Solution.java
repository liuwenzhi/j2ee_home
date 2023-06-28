package lkhwtk.leetcode767;

/**
 * 767. 重构字符串
 * 参考题解：java代码，击败了100%的用户
 * 本题核心思路：首先找到出现次数最多的字母，把它一个一个字母填到结果数组中，每两个字母之间隔一个空格，占用偶数位
 * 重复次数最多的填完了之后，填其他字母，如果偶数位还有空则填到偶数位，也是隔一个填一个，没有空的话填奇数位。
 */
public class Solution {
    public String reorganizeString(String S) {
        //把字符串S转化为字符数组
        char[] alphabetArr = S.toCharArray();
        //记录每个字符出现的次数
        int[] alphabetCount = new int[26];
        //字符串的长度
        int length = S.length();
        //统计每个字符出现的次数
        for (int i = 0; i < length; i++) {
            alphabetCount[alphabetArr[i] - 'a']++;
        }
        //max:字母出现最大次数，alphabet：alphabetCount数组中出现最大字母次数的下标位置
        //threshold：字母出现最大个数的临界值，不能超过数组长度的一般，右移一位相当于/2，这里用带符号右移，整数带不带符号无所谓
        int max = 0, alphabet = 0, threshold = (length + 1) >> 1;
        //找出出现次数最多的那个字符
        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] > max) {
                max = alphabetCount[i];
                alphabet = i;
                //如果出现次数最多的那个字符的数量大于阈值，说明他不能使得
                // 两相邻的字符不同，直接返回空字符串即可
                if (max > threshold)
                    return "";
            }
        }
        //到这一步说明他可以使得两相邻的字符不同，我们随便返回一个结果，res就是返回
        //结果的数组形式，最后会再转化为字符串的
        char[] res = new char[length];
        int index = 0;
        //先把出现次数最多的字符存储在数组下标为偶数的位置上，经过下边while循环的操作，出现最大次数的字母在alphabetCount数组中值已经是0了
        while (alphabetCount[alphabet]-- > 0) {
            //注意将数字转成字母的方式，数字直接和字母相加
            res[index] = (char) (alphabet + 'a');
            index += 2;
        }
        //然后再把剩下的字符存储在其他位置上
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i]-- > 0) {
                //如果index大于res.length，就从开始的奇数位开始填，也是隔一个填一个。
                if (index >= res.length) {
                    index = 1;
                }
                //如果index不大于res.length，就先把偶数位填满
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
