package lkhwtk.leetcode318;

/**
 * 318. 最大单词长度乘积
 * 参考题解：官方
 * 没有太好的方法，先获取不包含重复字母的单词集合，然后再拿着这个集合进行长度判断。注意官方题解中提到的：
 * 比较两个字符串是否有共同字符的方法，采用位操作
 */
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        //存放字符串字母掩码数组
        int[] masks = new int[n];
        //存放字符串长度数组
        int[] lens = new int[n];
        int bitmask;
        for (int i = 0; i < n; ++i) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                //添加第i位字母的掩码到bitmask中，公式实现见方法noCommonLetters的说明，bitNumber(ch)是几，就将1向左移动几位，最多25位，然后用或操作的方式添加到bitmask中
                bitmask |= 1 << bitNumber(ch);
            }
            //添加掩码
            masks[i] = bitmask;
            //添加字符串长度
            lens[i] = words[i].length();
        }
        //最终比较没有太好的优化方式，只能按照最笨的方式来
        int maxVal = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((masks[i] & masks[j]) == 0) {
                    maxVal = Math.max(maxVal, lens[i] * lens[j]);
                }
            }
        }
        return maxVal;
    }

    /**
     * 判断一个小写字母，在a到z这26个英文字母中的哪一个位置
     * a:0,b:1...z:25
     */
    private int bitNumber(char ch) {
        //直接用ch - 'a' 即可
        return (int)ch - (int)'a';
    }

    /**
     * 本方法是一个辅助测试说明的方法
     * 高效判断两个字符串是否有公共字符串的方式，找到字母掩码进行与操作。
     * 字母掩码：从a到z一共26个小写英文字母，字符串存在对应字母就在对应字母位设置为1，不存在设置为0
     * 比如：字符串abcd对应的掩码是：11110000000000000000000000，通过上边的bitNumber方法可以得到字母
     * 在字母掩码中出现的位置n，将第n位设置为1的方式为标准位移方式：1<<n，将1向左移动n位，这样就在字
     * 母掩码中把第n位设置为1，然后把某个字符串的全部字母掩码值通过或运算计算到一起，就得到这个字符串
     * 的一个标准的字母掩码集合，如果判断两个字符串是否有交集，直接将两个字符串的掩码值进行与操作，只
     * 有等于0的时候才说明没有交集
     */
    private boolean noCommonLetters(String s1, String s2) {
        int bitmask1 = 0, bitmask2 = 0;
        for (char ch : s1.toCharArray())
            bitmask1 |= 1 << bitNumber(ch);
        for (char ch : s2.toCharArray())
            bitmask2 |= 1 << bitNumber(ch);
        return (bitmask1 & bitmask2) == 0;
    }

}
