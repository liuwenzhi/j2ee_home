package lkhwtk.leetcode1198;

import java.util.HashMap;
import java.util.Map;

/**
 * 1198. 找出所有行中最小公共元素
 * 个人思路，基于hashMap实现
 */
public class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer,Integer> map = new HashMap<>();
        int rows = mat.length;
        int cols = mat[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                map.put(mat[i][j],map.getOrDefault(mat[i][j],0)+1);
                if(i==rows-1&&map.get(mat[i][j])==rows){
                    return mat[i][j];
                }
            }
        }
        return -1;
    }
}
