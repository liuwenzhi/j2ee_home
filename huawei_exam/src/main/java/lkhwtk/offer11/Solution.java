package lkhwtk.offer11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 二轮复习时看下官方的二分法
 */
public class Solution {
    public int minArray(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
