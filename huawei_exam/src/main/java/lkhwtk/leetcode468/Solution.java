package lkhwtk.leetcode468;

/**
 * 468. 验证IP地址
 * 参考题解：面向测试编程，一个个试。。。
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }

    /**
     * 验证ipv6地址方式，注意：ipv6地址是8组16进制数字
     */
    private boolean isIPv6(String ip) {
        String[] split = ip.split(":");
        if (split.length != 8 || ip.charAt(ip.length() - 1) == ':') return false;
        for (int i = 0; i < 8; i++) {
            if (split[i].length() < 1 || split[i].length() > 4) return false;
            for (int j = 0; j < split[i].length(); j++) {
                char c = split[i].charAt(j);
                if ((c < '0') || (c > '9' && c < 'A') || (c > 'F' && c < 'a') || (c > 'f'))
                    return false;
            }
        }
        return true;
    }

    /**
     * 验证ipv4地址，ipv4地址是四组十进制数字
     */
    private boolean isIPv4(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4 || ip.charAt(ip.length() - 1) == '.') return false;
        for (int i = 0; i < 4; i++) {
            if (split[i].length() < 1 || split[i].length() > 3) return false;
            if (split[i].length() != 1 && split[i].charAt(0) == '0') return false;
            for (int j = 0; j < split[i].length(); j++) {
                if (split[i].charAt(j) > '9' || split[i].charAt(j) < '0') return false;
            }
            int num = Integer.parseInt(split[i]);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
}
