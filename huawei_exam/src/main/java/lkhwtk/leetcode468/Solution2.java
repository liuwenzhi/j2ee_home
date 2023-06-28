package lkhwtk.leetcode468;

/**
 * 采用分治法验证IPv4和IPv6地址
 * 参考题解：官方
 */
public class Solution2 {
    /**
     * 验证ipv4地址方法
     */
    public String validateIPv4(String IP) {
        //这里split多了一个-1参数，代表按照点分隔字符串不受任何控制，比如遇到1.1.1.1.这种情况，不加limit=-1这个参数，就会
        //拆出1 1 1 1四个元素组成一个数组，如果是加了limit=-1，就会拆出1 1 1 1外加一个空字符串，这样更加方便验证
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // 验证ip地址按照0拆分后每个数字都在[0.255]之间:
            // 1. ip地址按照.拆分后每个数字的长度在[1,3]之间
            if (x.length() == 0 || x.length() > 3) return "Neither";
            // 2. 除非只有一个0，否则0不能单独作为ip地址按照.拆分后的每个数字的开头
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            // 3. ip地址按照.拆分后每个字符都必须是数字，这里需要用到一步内层循环
            for (char ch : x.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
            // 4. ip地址按照.拆分后每个数字的值不能大于255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
    }
    /**
     * 验证IPv6地址
     */
    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // 按照:拆分之后，每一个数组的范围在 [0, 2的16次幂-1]:
            // 1. 按照:拆分后，长度至少为1，不能大于4
            if (x.length() == 0 || x.length() > 4) return "Neither";
            // 2. 按照:拆分后，组成可以包括数字和大小写字母 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            //包括了3个点，去验证是否是IPV4地址
            return validateIPv4(IP);
        }else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            //包括了7个冒号，去验证是否是IPV6地址
            return validateIPv6(IP);
        }else{
            return "Neither";
        }
    }

    public static void main(String[] args){
        String s = "1.1.1.1.";
        String[] temp = s.split("\\.");//拆出1 1 1 1

        String[] temp1 = s.split("\\.",-1);//拆出1 1 1 1外加一个空字符串
        System.out.println(-1);

    }
}
