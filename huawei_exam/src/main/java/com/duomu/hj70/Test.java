package com.duomu.hj70;

public class Test {
    public static void main(String[] args){
        String s = "( A ( B C ) )";
        String c = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                c+=s.charAt(i);
            }
        }
        System.out.println(c);
    }
}
