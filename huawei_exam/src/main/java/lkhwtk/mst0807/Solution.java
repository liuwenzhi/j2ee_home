package lkhwtk.mst0807;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.07. 无重复字符串的排列组合
 * 参考题解：JAVA 无重复字符串排列
 */
public class Solution {

    /**结果数组*/
    List<String> res = new ArrayList<>();

    /**访问标记，1代表已访问，0代表未访问，本题中会存在01反复的替换*/
    int[] visited;
    public String[] permutation(String S) {

        visited = new int[S.length()];
        StringBuilder stringBuilder = new StringBuilder();
        backTrack(S,stringBuilder);
        //list列表转成String数组
        return res.toArray(new String[res.size()]);

    }

    /**
     * @param S 原始字符串
     * @param stringBuilder 缓存字符串
     */
    private void backTrack(String S,StringBuilder stringBuilder){
        //System.out.println(stringBuilder.toString());
        //递归方法出口，StringBuilder可以直接计算length，不用转字符串
        if(stringBuilder.length()==S.length()){
            res.add(stringBuilder.toString());
            return;
        }
        //for循环，每次循环，分别统计以第i的元素开头的排列信息
        for(int i=0;i<S.length();i++){
            if (visited[i] == 1) {
                //剪枝
                continue;
            }
            char c = S.charAt(i);
            visited[i] = 1;
            stringBuilder.append(c);
            backTrack(S,stringBuilder);
            // 撤销选择
            visited[i] = 0;
            //撤销选择之后需要删除掉sb的最后一个元素，这个非常重要
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.permutation("abc");
    }
}
