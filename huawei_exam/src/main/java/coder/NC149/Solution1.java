package coder.NC149;

/**
 * 优化思路：滑动窗口,借助StringBuilder对象代替字符串截取
 * 实际没有优化效果，只能呵呵。
 */
public class Solution1 {
    public int kmp (String S, String T) {
        // write code here
        int result = 0;
        int lenS = S.length();
        int lenT = T.length();
        StringBuilder stringBuilder = new StringBuilder();
        //先从T上截取一个初始值，判断下是否和S相等
        stringBuilder.append(T.substring(0,lenS));
        if(S.equals(stringBuilder.toString())){
            result++;
        }
        //窗口向右滑动，判断固定窗口大小内动态stringBuilder中的字符串知否和S相等
        for(int i=1;i<lenT-lenS+1;i++){
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(T.charAt(i+lenS-1));
            if(S.equals(stringBuilder.toString())){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        System.out.println(solution.kmp("ababab","abababab"));
        System.out.println(solution.kmp("abab","abacabab"));
    }
}
