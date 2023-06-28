package lkhwtk.leetcode1013;

/**
 * 1013. 将数组分成和相等的三个部分
 * 将数组三等分，注意：这里不能改变数组元素顺序
 * 参考题解：将数组分成和相等的三个部分 官方
 * 核心思路：先判断数组总和能不能被三等分，总和不能除开3，能出开3的情况下，去找3个三等分点，必须保证总和能被3整除的情况下还能找到3个三等分点
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        //数组中元素总和，target=总和/3
        int total = 0,target = 0;
        for(int num:arr){
            total += num;
        }
        //如果数组中元素的总和不能被三等分，则直接返回false
        if(total%3!=0){
            return false;
        }else{
            target = total/3;
            total = 0;
        }
        //寻找第一个三等分点
        int index1 = 0;
        for(int i=0;i<arr.length;i++){
            total += arr[i];
            if(total==target){
                index1 = i;
                break;
            }
        }
        if(total!=target){
            return false;
        }else{
            total = 0;
        }
        //寻找第二个三等分点
        int index2 = 0;
        for(int i=index1+1;i<arr.length;i++){
            total += arr[i];
            if(total==target){
                index2 = i;
                break;
            }
        }
        if(total != target){
            return false;
        }
        if(index1==arr.length-1||index2==arr.length-1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        //注意这个用例：一共170个数据，总和是0，index1=169，正好是0，最后一步的验证一定是：index1==arr.length-1||index2==arr.length-1
        int[] a = {99,32,89,-10,68,33,94,48,68,14,98,49,47,-18,-46,11,-78,-22,-70,-32,-74,71,3,100,60,-50,21,41,38,5,-20,-37,-73,-25,38,65,77,-83,50,-32,10,20,2,47,-93,27,-69,50,-10,-27,-90,19,57,-87,-59,80,-100,-13,-51,83,-4,-73,72,92,92,19,93,36,84,94,-42,83,44,92,-52,60,-11,-91,-71,-48,31,2,10,-22,-3,86,-77,-5,37,25,42,33,-83,40,-44,88,-64,-51,-66,46,-98,-63,-73,-30,-48,66,98,94,-9,-20,-60,97,-96,71,-69,25,53,64,86,-58,-26,6,-28,-58,-83,-89,33,34,38,-95,-30,-39,-50,-27,100,-76,17,-51,-68,-87,64,-54,-41,-56,91,70,2,81,-72,-13,-98,81,-42,36,-67,-48,-64,-24,-83,98,-32,18,84,-96,-26,46,-97,-60,-85,-3};
        System.out.println(solution.canThreePartsEqualSum(a));
    }
}
