package lkhwtk.leetcode299;

/**
 * 299. 猜数字游戏
 * 参考题解：一次遍历（1 ms，100.00%）
 * 本题看似不难，实际很容易绕进去，最好是通过数组来计算和比对字符数量相关信息
 */
public class Solution {
    public String getHint(String secret, String guess) {
        //本题是猜数字，范围只限于0到9 ，secretArray 和 guessArray 分别记录 两个字符串中非公牛的各个数字的数量
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        //处理公牛的情况公牛
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            // 如果同位的数字相等则，公牛++
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                //不处于同位相等的情况，则累加非公牛数字量
                secretArray[secret.charAt(i) - '0']++;
                guessArray[guess.charAt(i) - '0']++;
            }
        }
        // 奶牛
        int B = 0;
        for (int i = 0; i < 10; i++) {
            // 不同位上的相同数字的数量，每次比对都是取小的，非常巧的思路
            B += Math.min(secretArray[i], guessArray[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(A).append('A').append(B).append('B').toString();
        //注意：使用StringBuilder比直接返回字符串拼接快很多，能节省3ms左右
        //return A+"A"+B+"B";
    }

    public static void main(String[] agrs){
        Solution solution = new Solution();
        System.out.println(solution.getHint("1123","0111"));

    }
}
