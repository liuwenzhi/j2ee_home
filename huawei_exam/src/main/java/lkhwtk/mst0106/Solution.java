package lkhwtk.mst0106;

/**
 * 面试题 01.06. 字符串压缩
 */
public class Solution {
    public String compressString(String S) {
        if(S.length()==0){
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char c = S.charAt(0);
        char last = S.charAt(0);
        int num = 1;
        stringBuilder.append(c);
        for(int i=1;i<S.length();i++){
            c = S.charAt(i);
            if(c==last){
                num++;
            }else{
                stringBuilder.append(num).append(c);
                last = c;
                num=1;
            }
        }
        stringBuilder.append(num);
        if(stringBuilder.length()>=S.length()){
            return S;
        }
        return stringBuilder.toString();
    }
}
