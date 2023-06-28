package lkhwtk.leetcode1111;

/**
 * 1111. 有效括号的嵌套深度
 * 参考题解：官方题解视频说明不错
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        //输入空字符串的情况
        if(seq==null||seq.length()==0){
            return new int[0];
        }
        //临时深度变量,最大深度初始化为0
        int depth = 0,maxDepth = 0;
        //首次遍历字符串，计算出最大深度
        for(int i=0;i<seq.length();i++){
            char c = seq.charAt(i);
            if(c=='('){
                depth++;
                if(depth>maxDepth){
                    //如果深度变量值大于最大深度，则重新复制最大深度
                    maxDepth = depth;
                }
            }else{
                //如果遍历到右括号，则临时深度变量自减
                depth--;
            }
        }
        //最终返回结果数组，其中包括A和B两个部分
        int[] result = new int[seq.length()];
        //存放A数组计数变量，用于控制有括号是否分配到匹配的A数组中
        int aDepth = 0;
        //计算最大深度的一半，向上取整，这种向上取整的方式能避免出现内存溢出
        int mid = 1+(maxDepth-1)/2;
        for(int i=0;i<seq.length();i++){
            char c = seq.charAt(i);
            if(c=='('){
                if(aDepth<mid){
                    //A当前深度小于最大深度一半，遇到左括号加入
                    result[i] = 0;
                    aDepth++;
                }else{
                    //A当前深度不小于最大深度一半，加入当前元素到B数组中
                    result[i] = 1;
                }
            }else{
                if(aDepth>0){
                    //如果是有括号，A能加就加入
                    result[i] = 0;
                    aDepth--;
                }else{
                    //A加不了，放到B
                    result[i] = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.maxDepthAfterSplit("(()())");
    }
}
