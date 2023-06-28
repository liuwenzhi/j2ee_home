package lkhwtk.leetcode91;

/**
 * 针对于solution的优化，因为动态规划状态转移方程组，只涉及到当前值和之前两个值，
 * 所以可以使用变量的方式，替代dp数组，算法几乎双百
 */
public class Solution1 {
    public int numDecodings(String s) {
        //如果s以0开始，或者直接就是0，则返回0
        if("0".equals(s)||s.startsWith("0")){
            return 0;
        }
        //last,afterLast
        int last = 1;
        int afterLast = 1;
        int current = 1;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='0'){
                //数字为0的情况，0出现的最前边的位置是第二位
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    //如果0的前一位是1或者2，那么一起编码，不增加编码情况
                    current = last;
                }else{
                    return 0;
                }
            }else if(s.charAt(i-1)=='1'){
                current = last+afterLast;
            }else if(s.charAt(i-1)=='2'&&(c>='1'&&c<='6')){
                current = last+afterLast;
            }else{
                //不包含以上几种情况，就不会产生新的编码方式
                current = afterLast;
            }
            //最后需要修改last和afterLast的值，这里没有用dp数组，需要通过变量赋值方式前移元素
            last = afterLast;
            afterLast = current;
        }
        return current;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        System.out.println(solution.numDecodings("226"));
    }
}
