package lkhwtk.mst1001;

import java.util.Arrays;

/**
 * 面试题 10.01. 合并排序的数组
 * 个人老思路，归并排序求并集
 * 本题同主栈88题
 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        //通过数组拷贝创建数组：从A的第0位开始，拷贝m位
        int[] C = Arrays.copyOfRange(A, 0, m);
        int a=0,b=0,c=0;
        while(a<m+n&&b<n&&c<m){
            if(B[b]<C[c]){
                A[a] = B[b];
                b++;
            }else{
                A[a] = C[c];
                c++;
            }
            a++;
        }
        while(b<n){
            A[a++] = B[b++];
        }
        while(c<m){
            A[a++] = C[c++];
        }
    }
}
