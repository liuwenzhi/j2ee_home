package lkhwtk.leetcode1422;

/**
 * 1422. 分割字符串的最大得分
 * 思路参考：Java 两次遍历易懂思路（95.90%，95.50%）
 * 注意：左右子串得是非空，输入00，必须分隔为0,0
 */
public class Solution {
    public int maxScore(String s) {
        //初始化字符串中1的个数是0，0的个数是0
        int oneCount=0,zeroCount=0;
        int result = 0;
        //遍历String字符串，下边两种写法没有绝对的谁性能更好，测试多次之后差不太多
        /*for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                oneCount++;
            }
        }*/
        //先统计出字符串中全部1的数量
        for(char c:s.toCharArray()){
            if(c=='1'){
                oneCount++;
            }
        }
        //s.length()-1 这一步是一个技巧，保证最右边肯定得分一个非空子集，for循环可以这么来理解：每次遍历一个元素，就把这个元素划分到左侧
        //集合中，如果是0，则左侧集合中zeroCount自增，如果是1，则右侧集合中oneCount减减，最后至少要留一个元素不能划分到左侧集合中，也即：最右边的元素不能遍历
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                zeroCount++;
            }else{
                oneCount--;
            }
            result = Math.max(result,zeroCount+oneCount);
        }
        return result;
    }
}
