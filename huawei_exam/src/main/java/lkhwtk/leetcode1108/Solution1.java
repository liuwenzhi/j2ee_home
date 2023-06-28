package lkhwtk.leetcode1108;

/**
 * 参考题解：Java题解（0ms,36.1MB）
 * 这个题解比Solution时空效率好一点
 */
public class Solution1 {
    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                stringBuilder.append("[.]");
            }else{
                stringBuilder.append(address.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
