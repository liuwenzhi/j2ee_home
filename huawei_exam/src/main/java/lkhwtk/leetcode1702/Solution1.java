package lkhwtk.leetcode1702;

/**
 * 参考题解：Java 一次遍历实现，效率能高一些
 * 使用数组计算能减少一个循环
 * 备注：本题不用单独考虑入参全是0的情况，因为00可以转为10
 */
public class Solution1 {
    public String maximumBinaryString(String binary) {
        int L=binary.length();
        char[] letters=binary.toCharArray();

        //寻找字符串是否包含0，如果不包含，就说明字符串全为1，本身即为最大值
        int i=0;
        while(i<L && letters[i]=='1') i++;
        if(i==L) return binary;

        //用anchor记录0第一次出现的位置
        int anchor=i-1,count=0;
        while(i<L){
            if(letters[i]=='0') count++;
            letters[i]='1';
            i++;
        }
        //将anchor偏移，指向最后一个0聚合后的位置
        anchor+=count;
        //将该位置0
        letters[anchor]='0';
        return new String(letters);
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        //入参单独是一个0的情况也可以，anchor=-1，但是累加到count就是0了。
        System.out.println(solution1.maximumBinaryString("0"));
    }

}
