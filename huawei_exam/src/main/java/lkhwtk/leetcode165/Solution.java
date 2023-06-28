package lkhwtk.leetcode165;

/**
 * 165. 比较版本号
 * 本题题很长，实际比较简单
 * 题目中这一句不太好理解：修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推
 * 实际含义就是：上文提到的每一个.分隔的修订号，可以按照数字大小进行比较，然后基于后文，比较的时候可以忽略每一个修订号的前导0
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0;
        for(;i<v1.length&&i<v2.length;i++){
            int m = Integer.parseInt(v1[i]);
            int n = Integer.parseInt(v2[i]);
            if(m>n){
                return 1;
            }else if(m<n){
                return -1;
            }
        }
        //如果version1和version2版本号数量不同，然后存在一个包含另一个的情况，同时要注意这种情况：1.0和1.0.0
        if(i<v1.length){
            if(checkZero(v1,i)){
                return 0;
            }
            return 1;
        }else if(i<v2.length){
            if(checkZero(v2,i)){
                return 0;
            }
            return -1;
        }
        return 0;
    }

    /**
     * 判断版本号从index位开始往后是不是都是0
     */
    private boolean checkZero(String[] v,int index){
        for(int i=index;i<v.length;i++){
            if(Integer.parseInt(v[i])!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String v1 = "1.001.00002";
        String[] v11 = v1.split("\\.");
        for(int i=0;i<v11.length;i++){
            //Integer.parseInt()方法在转整形的时候，能直接忽略掉前导0
            System.out.println(Integer.parseInt(v11[i]));
        }
    }

}
