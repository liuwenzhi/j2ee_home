package lkhwtk.leetcode1209;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * 参考题解：官方暴力解法
 * 该思路能通过90%的测试用例，最后会超时
 */
public class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            //在这里给length赋值，每次执行完for循环之后，在while条件中判断是否有减少，减少了就继续下一次循环
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count == k) {
                    //算上当前元素，往前再删除k-1个元素，从i-k+1这个位置开始删除，到第i个位置，delete是前删除后不删除，相当于把重复数字都删掉
                    //比如abbbcc，删除b的时候，k=3，i=3,删除的位置是从1开始（i-k+1），删除到c前边这个元素
                    sb.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder("012345");
        //注意StringBuilder的delete方法，前边删除后边不删除
        stringBuilder.delete(0,3);
        System.out.println(stringBuilder.toString());

        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa",3));
    }
}
