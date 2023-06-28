package lkhwtk.leetcode470;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 本题属于纯数学归纳总结，通过枚举总结关系得到关系方程
 * 参考题解：从最基础的讲起如何做到均匀的生成随机数
 * 备注：本题理解到这里即可，时空效率已经能达到95%以上，最后一步优化暂时不用管。
 */
public class Solution extends SolBase{

    public int rand10() {
        while(true) {
            //等概率生成[1,49]范围的随机数
            int num = (rand7() - 1) * 7 + rand7();
            //拒绝采样，并返回[1,10]范围的随机数
            if(num <= 40) return num % 10 + 1;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        for(int i=0;i<100;i++) {
            System.out.println(solution.rand10());
        }
    }

}
