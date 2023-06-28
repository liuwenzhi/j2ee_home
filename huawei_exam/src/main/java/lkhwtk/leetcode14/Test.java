package lkhwtk.leetcode14;

public class Test {
    public static void main(String[] args){
        String s = "012345";
        while(true){
            //substring：前闭后开，如果截取到字符串末尾，则不输入第二个参数
            System.out.println(s.substring(0,s.length()));
            s = s.substring(0,s.length()-1);
        }
    }
}
