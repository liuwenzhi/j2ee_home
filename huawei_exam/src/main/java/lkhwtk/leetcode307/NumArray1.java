package lkhwtk.leetcode307;

/**
 * 参考题解：[线段数组]手绘图象一清二楚，抓住重点明白算法详情
 * 本题解是对官方题解的详细表述
 */
public class NumArray1 {
    /**线段树数组*/
    private int[] tree;
    private int n;

    /**
     * 在构造方法中构造线段树数组，可以结合题解123来理解
     */
    public NumArray1(int[] nums) {
        n = nums.length;
        //初始化线段树长度为2n
        tree = new int[n * 2];
        //初始化线段树
        for(int i = n; i < 2*n; i++){
            tree[i]  = nums[i-n];
        }
        for(int i = n-1; i >= 0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    /**
     * 更新值的时候，要重新构建线段树，结合题解截图，能够验证出这个更新算法的流程，可以当做模板记一下
     */
    public void update(int i, int val) {
        int pos = n + i;
        tree[pos] = val;
        while(pos > 0){
            int left = pos%2==0? pos: pos-1;
            int right = pos%2==0? pos+1: pos;
            //pos/2位置的值发生了变化，这个时候就需要继续修改其父节点
            tree[pos/2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    /**
     * 求区间i到j元素的和，结合题解截图，能够验证出这个求和算法的流程，可以当做模板记一下
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        //l和r为线段树数组中元素实际的位置
        int l = n + i;
        int r = n + j;
        while(r >= l){
            if(l % 2 == 1){
                sum += tree[l];
                l++;
            }
            if(r % 2 == 0){
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args){
        //System.out.println(-2 & 2);
        int[] nums = {1, 3, 5};
        NumArray1 numArray1 = new NumArray1(nums);
        System.out.println(numArray1.sumRange(0,2));
        numArray1.update(1,2);
        System.out.println(numArray1.sumRange(0,2));
    }

}
