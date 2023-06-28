package lkhwtk.leetcode423;

/**
 * Solution换一种数组写法，实际效率差不多，能节省一点内存空间，这个写法更符合个人思路,
 * count数组初始化为一个int类型数组即可
 */
public class Solution1 {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(char letter: s.toCharArray()) {
            count[letter-'a']++;
        }
        //所有偶数都有唯一字母，通过这个字母来确认
        int[] out = new int[10];
        // z只出现在0的拼写中，zero
        out[0] = count['z'-'a'];
        // letter "w" is present only in "two"
        out[2] = count['w'-'a'];
        // letter "u" is present only in "four"
        out[4] = count['u'-'a'];
        // letter "x" is present only in "six"
        out[6] = count['x'-'a'];
        // letter "g" is present only in "eight"
        out[8] = count['g'-'a'];
        //偶数确认完了之后可以确认3,5,7
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'-'a'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'-'a'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'-'a'] - out[6];
        //最后确认9和1
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'-'a'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'-'a'] - out[7] - 2 * out[9];

        //0~9直接可以和out数组的下标对应，就不用单独初始化一个数字数组了，直接通过i进行拼接即可，out[i]代表i这个数字出现的次数
        StringBuilder output = new StringBuilder();
        //注意：数字可能有重复，所以不能按照这种方式输出
        /*for(int i = 0; i < 10; i++){
            if(out[i]!=0){
                output.append(i);
            }
        }*/
        //数字有可能有重复的情况，所以需要用一个内层循环做重复输出，比如结果为00，则0需要拼接两次
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < out[i]; j++){
                output.append(i);
            }
        }
        return output.toString();
    }
}
