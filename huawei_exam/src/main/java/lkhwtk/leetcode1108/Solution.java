package lkhwtk.leetcode1108;

/**
 * 1108. IP 地址无效化
 */
public class Solution {
    public String defangIPaddr(String address) {
        String[] temp = address.split("\\.");
        return String.join("[.]",temp);
    }

    public static void main(String[] args){
        String a = "192.168.1.125";
        String[] temp = a.split("\\.");
        System.out.println(String.join("[.]",temp));
    }
}
