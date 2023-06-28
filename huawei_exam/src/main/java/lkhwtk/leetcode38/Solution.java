package lkhwtk.leetcode38;

/**
 * 38. 外观数列
 * 个人原创：分两步：第一步：写一个方法根据一个字符串写出外观数列getNum4String
 * 第二步：从1开始找到n的字符串，分别写出外观数列
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=0;i<n-1;i++){
            s = getNum4String(s);
        }
        return s;
    }

    private String getNum4String(String s){
        StringBuilder cache = new StringBuilder();
        char c = s.charAt(0);
        int num = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i==0){
                cache.append(c);
                num = cache.toString().length();
            }else{
                if(c==s.charAt(i)){
                    cache.append(c);
                    num = cache.toString().length();
                }else{
                    result.append(num).append(c);
                    //删除0到cache.length()前包含后不包含，setLength(0)相对来说清空StringBuilder效率更高，也可以new  StringBuilder()，效率偏低
                    //cache.delete(0,cache.length());
                    cache.setLength(0);
                    c = s.charAt(i);
                    cache.append(c);
                    num = cache.toString().length();
                }
            }
        }
        result.append(num).append(c);
        return result.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "3322251";
        System.out.println(solution.getNum4String("111221"));
        //System.out.println(solution.countAndSay(5));
    }
}
