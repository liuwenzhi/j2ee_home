package lkhwtk.leetcode66;

/**
 * 66. 加一
 * 直接转整累加可能有越界问题需要单独处理，可详细见Test类中说明
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        /*int temp = digits[0];
        for(int i=1;i<digits.length;i++){
            temp = temp*10 + digits[i];
        }
        temp++;
        int[] result = new int[String.valueOf(temp).length()];
        for(int i=result.length-1;i>=0;i--){
            result[i] = temp%10;
            temp = temp/10;
        }
        return result;*/
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            //每次进位增加1，最大得10
            if(digits[i]==10){
                digits[i] = digits[i]%10;
            }else{
                //没有进位直接返回结果
                return digits;
            }
        }
        //如果走到循环之外，证明一直都有进位，则扩容数组，增加一个1，这种情况发生在9 9 9 9这种数组中，最终扩容之后，digits[0]置为1，数组变成1 0 0 0 0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args){
        int[] a = {9,9,9,9};
        Solution solution = new Solution();
        System.out.println(solution.plusOne(a));
    }
}
