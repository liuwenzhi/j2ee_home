package lkhwtk.leetcode46;

import java.util.*;

/**
 * 46. 全排列
 * 参考题解：官方视频解法
 * 注意两个思路核心点：深度优先遍历，在递归函数里通过循环产生分支。
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        //返回值空列表初始化为一个动态列表
        List<List<Integer>> result = new ArrayList<>();
        if(length==0){
            return result;
        }
        //注意这里队列的定义方式，和39题40题一致
        Deque<Integer> path = new ArrayDeque<>();
        //记录已经使用的数组元素，默认为false，不用初始化
        boolean[] used = new boolean[length];
        dfs(nums,length,0,path,used,result);
        return result;
    }

    /**
     * 基于深度优先遍历的思路得到全排列
     * @param nums 原始数组
     * @param length 数组实际长度
     * @param depth 当前遍历到树的第几层
     * @param path 遍历路径栈
     * @param used 元素使用数组
     * @param result 最终结果
     */
    private void dfs(int[] nums,int length,int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> result){
        //第一步：递归终止条件，遍历的深度达到了数组的长度，则将path放到result里边
        if(depth==length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<length;i++){
            if(used[i]){
                continue;
            }
            //从尾部加入
            path.add(nums[i]);
            used[i] = true;
            //进行下一层的递归
            dfs(nums,length,depth+1,path,used,result);
            //之后回到上一层，之前做了什么，之后就需要做同样的逆操作，这个过程就是回溯
            used[i] = false;
            //从尾部删除
            path.removeLast();
        }

    }

    public static void main(String[] args){
        /*Deque<Integer> path = new ArrayDeque<>();
        path.add(1);
        path.add(2);
        path.add(3);
        while(!path.isEmpty()){
            System.out.println(path.poll());
        }*/
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> result = solution.permute(nums);
        List<Integer> prev = result.get(0);
        for(int i=1;i<result.size();i++){
            List<Integer> cur = result.get(i);
            if(cur.get(0)==2&&cur.get(1)==3&&cur.get(2)==1){
                System.out.println(prev.get(0)+","+prev.get(1)+","+prev.get(2));
                break;
            }
            prev = cur;
        }

    }
}
