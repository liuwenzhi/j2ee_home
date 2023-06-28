package lkhwtk.leetcode423;

/**
 * 423. 从英文中重建数字
 * 思路参考：从英文中重建数字 官方
 * 注意：本题思路属于一种取巧的思路，
 */
public class Solution {

    public String originalDigits(String s) {
        /*注意这个数组的定义方式：看似非常怪，a的ASCII码是97，实际是定义了一个长度为123的数组，初始化之后，数组中的元素值是：'\u0000' 0，
        直接看不了（main验证），要看具体的值需要对元素进行强转，比如(int)count[0],或者int a = count[0];再输出a看值。这种定义方式让一个字符数组
        起到了hashmap的作用，从97开始到122，可以直接用数字编号转成对应的字符，比如98对应b，101对应e，111对应o，最后边122对应z，结合强转看
        值的方式：(int)count['o']，(int)count[111]，int a = count[111]再输出a，具体的值在进行强转之后，实际值为对应数组编号的字母出现
        的次数*/
        char[] count = new char[26 + (int)'a'];
        for(char letter: s.toCharArray()) {
            count[letter]++;
        }
        //所有偶数都有唯一字母，通过这个字母来确认
        int[] out = new int[10];
        // z只出现在0的拼写中，zero
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        //偶数确认完了之后可以确认3,5,7
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        //最后确认9和1
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

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

    public static void main(String[] args){

        String s = "owoztneoer";
        //a的ascii码是97
        char[] count = new char[26 + (int)'a'];
        for(char letter: s.toCharArray()) {
            count[letter]++;
        }
        /*for(int i=0;i<count.length;i++){
            System.out.println((int)count[i]);
        }*/
        int a = count['o'];
        System.out.println((int)count[111]);

    }
}
