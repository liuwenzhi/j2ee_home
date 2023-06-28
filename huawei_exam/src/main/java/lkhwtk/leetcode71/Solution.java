package lkhwtk.leetcode71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. 简化路径
 * 备注：实例4中的目录：
 * /a/./b/../../c/，进入根目录下a目录，当前目录，进入a目录下b目录，退回到a目录，退回到根目录，进入c目录，实际是
 * 在根目录下有一个c目录，直接简化为/c即可
 * 参考题解：双端队列，linux的思路
 * 核心的点：单独处理 . .. 多个斜杠/// 空字符串
 */
public class Solution {
    public String simplifyPath(String path) {
        //借助队列实现
        Deque<String> queue = new LinkedList<>();
        //分割字符，按照/拆分，如果是//则拆分出空字符串
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")){
                //当前目录
                continue;
            }else if (s.equals("..")){
                //..的时候队列尾部出队，返回上一级目录
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                //在队列尾部加入s
                queue.offer(s);
            }
        }
        // 从队头开始拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    public static void main(String[] args){
        //注意：这种情况按照/拆分，会拆分出空字符串
        String path = "/a/b//c////d";
        String[] temp = path.split("/");
        for(int i=0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
       /* Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));*/
        //算法执行流程：a从队尾入队，b从队尾入队，队列中元素为：a(头) b（尾），然后..队尾b出队，再执行..队尾a出队，最后c从队尾入队
    }
}
