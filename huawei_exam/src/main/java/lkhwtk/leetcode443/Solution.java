package lkhwtk.leetcode443;

/**
 * 443. 压缩字符串
 * 个人思路，效率很高
 */
public class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return chars.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char pre = chars[0];
        stringBuilder.append(pre);
        int count = 1;
        for(int i=1;i<chars.length;i++){
            char c = chars[i];
            if(c==pre){
                //当前循环字符c等于前缀就累加count
                count++;
            }else{
                //当前循环字符c不等于前缀，判断下前缀的count是否大于1，即是否需要压缩，需要压缩再拼
                if(count>1) {
                    stringBuilder.append(count);
                }
                //拼接新字符，更新前缀为当前字符，更新count值为1
                stringBuilder.append(c);
                pre = c;
                count=1;
            }
        }
        //补最后一次循环可能没算上的数量统计
        if(count>1) {
            stringBuilder.append(count);
        }
        char[] changed = stringBuilder.toString().toCharArray();
        //注意：本题必须要改动chars数组，一个一个元素的改，然后还得返回changed数组的长度
        for(int i=0;i<changed.length;i++){
            chars[i] = changed[i];
        }
        return changed.length;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b','c','c'};
        solution.compress(c);
    }
}
