package lkhwtk.leetcode66;

/**
 * 备注：本题直接累加，只能跑完53%的用例，可能出现数组中组合的数字大于整形最大数字
 * 2147483647
 */
public class Test {
    public static void main(String[] args){
        //2147483647
        //9876543210
        //System.out.println(9876543210);
        int[] a = {1,2,3,4};
        a = new int[a.length+1];
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
