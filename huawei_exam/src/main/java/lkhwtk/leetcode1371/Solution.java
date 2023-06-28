package lkhwtk.leetcode1371;

import java.util.Arrays;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 参考题解：官方
 * 建立一个32位长度的数组，保存经过压缩的元音字母奇偶性状态值出现的位置，如果同个奇偶性状态值出现了两次，则它们之间的子串一定是包含偶数个元音字母
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        //预留一个开始位是0，比如for循环中最开始得到的status是0，那么ans=1，后边记录都是i+1，涉及到前缀和的问题首位都需要单独处理下
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //基于奇偶性对uoiea这个顺序的字符串进行压缩，1每次左移一定位数，和具体字母对应上，执行一次抑或操作就改变了一次奇偶性
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                //如果同一个状态值出现了两次，则肯定两个子串之间的元音字母是偶数，用当前的位置值减去上一次出现的位置值就是子串得长度
                //注意：这里也是用i+1位置和之前的位置做差，求出两个位置之间的子串长度，这个差值实际上不包括上一个pos[status]位置，包括当前位置
                ans = Math.max(ans, i+1- pos[status]);
            } else {
                //如果状态值头一次出现，则记录这个位置值，注意：记录的位置是当前子串结束位置的下一个位置，主要是算法需要：
                //开始预留了一个0了，后边计算的时候都累积到下一个位置，实际对应字符串的1到n位全部，注意：如果在i=0的位置上，status值为0，不走这个分支，此时ans已经等于1了
                pos[status] = i+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        //System.out.println(solution.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(solution.findTheLongestSubstring("l"));
    }
}
