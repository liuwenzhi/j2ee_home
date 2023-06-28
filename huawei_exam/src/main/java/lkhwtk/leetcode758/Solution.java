package lkhwtk.leetcode758;

/**
 * 758. 字符串中的加粗单词
 * 参考题解：java解法 beats 100%
 * 本题不难，题目说明有不清晰的地方，可能是一些符号类型的内容没有加载上来。
 * 实际含义：给S中包含words中的单词进行加粗，加粗用<b></b>这种形式放到字符串中，
 * 然后不能出现 <b><b></b></b>这种嵌套形式或者<b><b></b>...</b>这种交际形式，
 * 总之不能出现多个出现重合区间的<b></b>，算法的核心思路是通过String类的indexOf
 * 方法找到出现单词的位置，然后单独记录一个boolean数组，把需要加粗的字母的通过对
 * 应位置的编号记录为ture，最后根据这个bool数组，把S中需要加粗的地方加粗，注意开头和结尾不能落下。
 */
public class Solution {
    public String boldWords(String[] words, String S) {
        //创建一个标记加粗的数组
        boolean[] isBold = new boolean[S.length()];
        for (String word : words) {
            //从第0位开始找，S中包含word的位置，n记录匹配单词的开始位置
            int n = S.indexOf(word, 0);
            while (n != -1) {
                for (int i = n; i < n + word.length(); i++) {
                    isBold[i] = true;
                }
                //匹配完成之后，从匹配开始位置后一位，n+1的位置开始继续寻找，而不是从n+word.length开始找，比如s中是aaaaaa，words中包含aa
                n = S.indexOf(word, n + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        //字符串开头拼一个<b>
        if (isBold[0]) {
            sb.append("<b>");
        }
        for (int i = 0; i < isBold.length; i++) {
            //拼上字母
            sb.append(S.charAt(i));
            if (i == isBold.length - 1) {
                //如果是字符串结尾，并且需要加粗，则拼一个</b>
                if (isBold[i]){
                    sb.append("</b>");
                }
                //处理完结尾直接跳出，不跳出后边会字符串数组越界
                break;
            }
            //当前字母需要加粗，后一个不需要加粗，则拼完当前字母之后再拼一个</b>结束
            if (isBold[i] && !isBold[i + 1]){
                sb.append("</b>");
            }
            //当前字母不需要加粗，后一个字母需要加粗，则拼一个<b>开始
            if (!isBold[i] && isBold[i + 1]){
                sb.append("<b>");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String[] words = {"ab", "bc"};
        String S = "aabcd";
        boolean[] isBold = new boolean[S.length()];
        for (String word : words) {
            //从第0位开始找，S中包含word的位置
            int n = S.indexOf(word, 0);
            while (n != -1) {
                for (int i = n; i < n + word.length(); i++) {
                    isBold[i] = true;
                }
                n = S.indexOf(word, n + 1);
            }
        }


    }
}
