package lkhwtk.leetcode605;

/**
 * 题目：605. 种花问题
 * 解题参考：【1】种花问题：简单的贪心
 * 从左向右遍历花坛，在可以种花的地方就种一朵，能种就种（因为在任一种花时候，不种都不会得到更优解），就是一种贪心的思想
 * 这里可以种花的条件是：
 *
 * 自己为空
 * 左边为空 或者 自己是最左
 * 右边为空 或者 自己是最右
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //如果n是0，则直接返回true，不需要种花
        if(n==0){
            return true;
        }
        for(int i=0;i<flowerbed.length;i++){
            //本题这个细节注意下：目前版本是基于jdk8，i==0||flowerbed[i-1]==0和i==flowerbed.length-1||flowerbed[i+1]==0这两个条件都没有报数组下表越界异常
            if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
            //if(flowerbed[i]==0&&(i==0||i!=0&&flowerbed[i-1]==0)&&(i==flowerbed.length-1||i!=flowerbed.length-1&&flowerbed[i+1]==0)){
                n--;
                //n等于0了，就ok了
                if(n==0){
                    return true;
                }
                flowerbed[i] = 1;
            }
        }
        //如果经过上边的if判断和for循环，没有返回，则返回false
        return false;
    }

    public static void main(String[] args){
        int[] a = {0,1,2,3};
        for(int i=0;i<a.length;i++){
            if(i==0||a[i-1]>0){
                System.out.println(a[i]);
            }
        }
    }
}
