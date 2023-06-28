package lkhwtk.leetcode125;

/**
 * 125. 验证回文串
 * 个人思路：使用双指针效率很高
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if("".equals(s.trim())){
            return true;
        }
        //i前指针，j是后指针
        for(int i=0,j=s.length()-1;i<j;){
            char before = s.charAt(i);
            char end = s.charAt(j);
            //如果i指向元素不是字母也不是数字
            if(!Character.isDigit(before)&&!Character.isLetter(before)){
                i++;
                continue;
            }
            //如果j指向元素不是字母也不是数字
            if(!Character.isDigit(end)&&!Character.isLetter(end)){
                j--;
                continue;
            }
            //注意本题的一个坑点：大写字母和小写字母对应的ascii码差32，另外有一个特殊的：数字0和字母P也是差32
            if(before=='0'&&end=='P'||before=='P'&&end=='0'){
                return false;
            }
            if(before-end==32||before-end==-32||before==end){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.isPalindrome("0P");
        System.out.println('B'-'b');
    }
}
