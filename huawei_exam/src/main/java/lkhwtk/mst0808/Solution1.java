package lkhwtk.mst0808;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 采用类似47题和40题的去重思路
 */
public class Solution1 {
    /**结果数组*/
    List<String> res = new ArrayList<>();

    /**访问标记，1代表已访问，0代表未访问，本题中会存在01反复的替换*/
    int[] visited;
    public String[] permutation(String S) {

        visited = new int[S.length()];
        StringBuilder stringBuilder = new StringBuilder();
        //原始字符串转字符数组，同时进行排序
        char[] C = S.toCharArray();
        Arrays.sort(C);
        backTrack(C,stringBuilder);
        //list列表转成String数组
        return res.toArray(new String[res.size()]);

    }

    /**
     * @param C 原始字符串转字符数组
     * @param stringBuilder 缓存字符串
     */
    private void backTrack(char[] C,StringBuilder stringBuilder){
        //System.out.println(stringBuilder.toString());
        //递归方法出口，StringBuilder可以直接计算length，不用转字符串
        if(stringBuilder.length()==C.length){
            res.add(stringBuilder.toString());
            return;
        }
        //for循环，每次循环，分别统计以第i的元素开头的排列信息
        for(int i=0;i<C.length;i++){
            if (visited[i] == 1||(i>0&&C[i]==C[i-1]&&visited[i-1]==0)) {
                //剪枝
                continue;
            }
            visited[i] = 1;
            stringBuilder.append(C[i]);
            backTrack(C,stringBuilder);
            // 撤销选择
            visited[i] = 0;
            //撤销选择之后需要删除掉sb的最后一个元素，这个非常重要
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
